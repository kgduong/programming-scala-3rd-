package chapter_24

import scala.collection.immutable.HashMap


object Collections {
  //Collections in Scala are easy to use, concise, safe, fast, and universal
  //  - Easy to use => collections are functional, side effect free, and wrapped

  //Scala collections come in the form of 3 subpackages:
  //  1. mutable => collections that are mutable in nature
  //  2. immutable
  //  3. generic => building blocks of the collections package, should only be accessed in strict circumstances


  //Collection Consistency:
  //Every collection can be created by the same uniform syntax
  val traverse = Traversable(1,2,3)
  val map = Map(1 -> 2, 3 -> 4)

  //Same rule is applied to collection implementations
  val list = List(1,2,3)
  val hashMap = HashMap("a" -> 1, "b" -> 2)
}
