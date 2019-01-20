package chapter_25

import collection._
/*
  Integrating a new map into collection framework
  Implements a mutable map with key: String, by a "Patricia trie"
  "PATRICIA" => "Practical Algorithm to Retrieve Information Coded in Alphanumeric"
    - store a set or map as a tree, where subsequent characters in a search key determines a descendant tree
    - As a map, value that's associated with a key is stored in nodes that can be reached by that key
 */
class PrefixMap[T] extends mutable.Map[String,T]
    with mutable.MapLike[String, T, PrefixMap[T]]{

  var suffixes: immutable.Map[Char, PrefixMap[T]] = Map.empty
  var value: Option[T] = None

  def get(s: String): Option[T] =
    if(s.isEmpty) value
    else suffixes.get(s(0)) flatMap(_.get(s substring 1))
    //recursively traverse suffixes trie

  //
  def withPrefix(s: String): PrefixMap[T] =
    if(s.isEmpty) this
    else{
      val leading = s(0)
      //check if leading character is in our map, if not add it
      suffixes get leading match {
        case None => suffixes = suffixes + (leading -> empty)//empty is a map default
        case _ =>
      }
      suffixes(leading) withPrefix(s substring 1)//recursively call prefix on tail of our string
    }

  override def update(s: String, elem: T) =
    withPrefix(s).value = Some(elem)

  override def remove(s: String): Option[T] =
    if(s.isEmpty){
      val prev = value
      value = None
      prev
    }
    else suffixes get s(0) flatMap(_.remove(s substring 1))//traverse down tree to remove from map

  def iterator: Iterator[(String, T)] =
    (for (v <- value.iterator) yield ("", v)) ++
      (for ((chr, m) <- suffixes.iterator;
          (s,v) <- m.iterator)
        yield (chr +: s, v))

  //Add new items to suffixes map
  def += (kv: (String, T)): this.type = {
    update(kv._1, kv._2)
    this
  }

  def -=(s: String): this.type = {
    remove(s)
    this
  }

  override def empty = new PrefixMap[T]
}

/*
  - To fully integrate a new collection class into a framework:
    1. Decide immutable versus mutable
    2. Pick right base traits for collection
    3. Inherit from right implementation trait to implement most collection operations
    4. If you map/similar operations, provide implicit CanBuildFrom to companion object
 */
