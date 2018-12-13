package chapter_17

import scala.collection.mutable

object SetsAndMaps{

  //Scala provides mutable and immutable Sets and Maps
  //The immutable variants are more encouraged so they're implicitly imported into
  //  ever Scala source file with a Predef object

  //type keyword for alias of the collections
  type Map[A, +B] = collection.immutable.Map[A, B]
  type Set[A] = collection.immutable.Set[A]


  //Using sets
  //sets is a container for distinct ("==") objects
  def createDistinctSet(text: String): mutable.Set[String] = {
    val wordsArray = text.split("[ !,.]+") //passing in a regex to split
    wordsArray.foldRight(collection.mutable.Set.empty[String])((s, set) => set += s)
  }

  //Using maps
  val nums = Map("i" -> 1, "ii" -> 2)
  nums + ("vi" -> 6)
  nums ++ List("iii" -> 3, "v" -> 5)

  //The class returned by scala.collection.immutable.Set and scala.collection.immutable.Factory vary depending on the length of your object
  // for sets and classes with length < 5, SetN and MapN is used
  //  aka Set1(), Set2(), or Map1() and Map4()
  //val isMap1 = Map("i" -> 1) == scala.collection.immutable.Map1
  //val isSet4 = Set(1,2,3,4) == scala.collection.immutable.Set4

  //Once you implement a map or set >= 5, HashSet and HashMap are used
  //This is done to maximize performance


  //In situations where you need a sorted Set or Map, use TreeSet and TreeMap
  //both use red-black trees to keep elements/keys in order
  //Order is determined by the Ordered trait
  //both only come in immutable variants
  import scala.collection.immutable.{TreeMap, TreeSet}
  val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
  val cs = TreeSet('f', 'u', 'n')
  val treeMap = TreeMap(33 -> 'x', 0 -> 'a', 27 -> 'b')
}
