package chapter_24

object Streams {
  //Like a list, except its elements are computed lazily, hence Streams can be infinitely long
  //Only elements requested will be computed
  val streamExample = 1 #:: 2 #:: 3 #:: Stream.empty //example of Stream cons operation

  //Fibonacci function that is lazily requested
  //The Fibonacci numbers themselves won't be constructed until requested
  def FibFrom(a: Int, b: Int): Stream[Int] =
    a #:: FibFrom(b, a + b)

}

object Vectors{
  //Provide constant access time to elements beyond the head
  //Vectors are represented as broad, shallow trees:
  //  - Every tree node contains up to 32 element of the vector or other tree nodes
  //Vectors are immutable, so any update method requires constructing a new Vector and tree
  val vec = Vector(1,2,3)
  val vec2 = vec updated (2, 4) //Return a new element with

  //Because they provide a good balance between fast random selections and fast random functional updates,
  //  Vectors are default implementation of immutable Indexed Sequences
  val shouldBeVector = collection.immutable.IndexedSeq(1,2,3)
}

object Ranges{
  //A range is an ordered sequence of integers that are equally spaced apart.
  val range1 = 1 to 3
  val range2 = 5 to 14 by 3

  //For a range that is exclusive of its upper limit, use "until"
  val exclusiveUntil = 1 until 3
  //Ranges are represented in constant space, as they can be defined by just 3 numbers: start, end, and stepping value

}

object HashTries{
  //Hash tries are a standard way to implement immutable sets and maps efficiently
  //Representation is similar to Vector, using a tree w/ 32 nodes but the selection is done via hash code

  //They strike a a balance between fast lookups and efficient functional insertions/deletions
  //Are default implementations for immutable sets and maps

}

object RedBlackTrees{
  //Red black trees are balanced binary trees, with log(n) operations
  //can call upon them using TreeSet and TreeMap
  val treeSet = collection.immutable.TreeSet.empty[Int]
  val treeSetWithElements = treeSet + 1 + 2 + 3 //should log(n) time

  //RedBlack trees are also the standard implementation of SortedSet in Scala, since they provide efficient iterator
}

object ImmutableBitSets{
  //Represents a collection of small integers as the bits of a larger integers
  //Internally used as a representation of 64-bit longs

}

object ListMaps{
  //Represents a map as a linked list of KVPs
  //Operations take O(n) to size of the ma
}