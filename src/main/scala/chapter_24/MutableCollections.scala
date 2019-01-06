package chapter_24

import scala.collection.mutable

object ArrayBuffers{
  //Array buffer holds an array and a size
  //Array buffers can have data efficiently added to the end, appending an item takes amortized constant time
  //Useful for efficiently building up large collection with new items appended to end
  val buf = collection.mutable.ArrayBuffer.empty[Int]
  buf += 1
  buf += 10
}

object ListBuffers{
  //An array buffer except that it uses a linked list internally
  //Best use to eventually convert to a list
  val buf = collection.mutable.ListBuffer.empty[String]
  buf += "Kobe"
  buf += "Bryant"
}

object StringBuilders{
  //imported into namespace by default
  val buf = new StringBuilder
  buf ++= "Los Angeles"
  buf += ' '
  buf ++= "Lakers"
  val kylesFavoriteTeam = buf.toString
}

object MutableLists{
  //Linked List:
  //  - mutable sequences consisting of nodes that are linked with next pointers
  //  - empty nodes point back to themselves as a cycle

  //Double Linked List
  //  - nodes point backwards and forwards

  //Mutable Lists
  //  - singly linked list with a sentinel node at the end to have quick access to end
}

object Queues{
  //Provides mutable queues in additional to immutable
  val queue = new mutable.Queue[String]()
  queue += "element1"
  queue += "element2"

}

object WeakHashMaps{
  //Hash Map where gc does not follow links from map to keys stored in it
  //  - a key and value pair will disappear from map if there no references to that key
  //  - Best used for caching, where unused data is removed automatically
}

