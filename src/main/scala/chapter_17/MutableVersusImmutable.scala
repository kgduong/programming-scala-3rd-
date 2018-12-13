package chapter_17

object MutableVersusImmutable {
  //Start solving a problem with immutable collections first, then transfer to mutable when needed
  //When you're making copies of a mutable collection || who owns/contains a mutable collection, consider use immutable

  //immutable collections are compact and better stored
  //An empty mutable HashMap takes up about 80 bytes
  val emptyMutableHashMap = scala.collection.mutable.HashMap.empty[String,Int]
  //immutable maps and sets with up to 4 entries are even more compact

  //when declaring an immutable map with a "var", Scala compiler will interpret += as mutable
  var emptyImmutableHashMap = Map.empty[String, Int]
  emptyImmutableHashMap += ("Kobe" -> 24)
  //Scala compiler creates a new immutable HashMap with the new value inside of it and set it's reference

  //This syntactic sugar provided by the Scala compiler also works for other types
  var roughlyPi = 3.0
  roughlyPi += 0.1
  roughlyPi += 0.04
}
