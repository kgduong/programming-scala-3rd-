package chapter_17

abstract class Sequences

class ListsExample extends Sequences{
  //Lists in scala are immutable linked-lists
  //Give fast addition and removal of items at the beginning of lists
  //however give poor performance for arbitrary indexing
  val colors = "red"::"blue"::"green"::Nil
  val colorsHead = colors.head
  val colorsTail = colors.tail
}

class ArraysExample extends Sequences{
  //Sequence of elements with efficient access to indexing
  val fiveToOne = Array(1,2,3,4,5)
  val randomArray = Array.emptyIntArray
}

class ListBufferExample extends Sequences{
  //When you need to build a list by appending, consider building it in reverse
  //Alternative would be to use ListBuffer
  import scala.collection.mutable.ListBuffer
  val buf = new ListBuffer[Int]
  buf += 1
  buf.toList
  //A reason to use ListBuffer instead of List is to prevent stack overflow
}

class ArrayBufferExample extends Sequences{
  import scala.collection.mutable.ArrayBuffer
  //All array options are available in an Array Buffer, but a bit slower due to a wrapper layer
  //Can add and remove elements at the beginning and end of an array
  val buf = new ArrayBuffer[Int]()
  buf += 12
  buf += 15
}

class StringOpsExample extends Sequences{
  //StringOps implement many sequence methods for Strings
  //Predef has an implicit conversion from String to StringOPs, you can treat strings as a sequence
  def hasUpperCase(s: String) = s.exists(_.isUpper)
  //The String class itself has no method ".exists"
  //The Scala compiler implicitly converts s to StringOps to execute .exists()
}