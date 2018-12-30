package chapter_22
import scala.collection.mutable.ListBuffer

//Abstract base class for List variants in Scala
//Scala list have 2 hierarchy children: :: and Nil
abstract class NewList[+T]{
  def isEmpty: Boolean
  def head: T
  def tail: NewList[T]

  //Other methods can be written using the basic 3
  def length: Int = if(isEmpty) 0 else 1 + tail.length
  def drop(n: Int): NewList[T] =
    if(isEmpty) NewNil
    else if(n <= 0) this
    else tail.drop(n-1)
  def map[U](f: T => U): NewList[U] =
    if(isEmpty) NewNil
    else chapter_22.::(f(head),tail.map(f))

  //Both append and concatenation requires polymorphic
  //This allows the new list type to be as "wide" as possible
  //[U >: T] is a flexible operator defining U as a supertype of T
  def ::[U >: T](x: U): NewList[U] = chapter_22.::(x, this)
  //list concatenation is also similar
  def :::[U >: T](prefix: NewList[U]): NewList[U] =
    if(prefix.isEmpty) this
    else prefix.head :: prefix.tail ::: this

  //typical access patterns for a list is recursive, example would be increment all elements
}


//Nil object inherits from NewList
case object NewNil extends NewList[Nothing]{
  override def isEmpty : Boolean = true
  def head: Nothing = throw new NoSuchElementException("head of empty list")
  def tail: NewList[Nothing]  = throw new NoSuchElementException("tail of empty list")
}

//:: pronounced cons for "construct" represents non-empty lists
//x::xs really means ::(x,xs) where you're constructing a new cons class
final case class ::[T](hd: T, private var tl: NewList[T]) extends NewList[T]{

  def head = hd
  //tl is a var, meaning it can be altered after constructed, but only within the scala package due to private[scala]
  def tail = tl
  //every class parameter is implicitly also a field of the class, so we can use head and tail in parameter
  override def isEmpty = false


  //optimized version of map useing a list buffer
  //map as is constructed in NewList is inefficient due to potential stack overflow
  def map[U] (xs: List[T])(f: T => U) = {
    val b = new ListBuffer[U]
    var these = xs
    while(!these.isEmpty){
      b += f(these.head)
      these = these.tail
    }
    b.toList
  }
}


//When needing to append elements of a list to the end, one can use a list buffer
private object ListBufferExample{
  def example(xs: List[Int]) = {
    val buf = new ListBuffer[Int]
    for(x <- xs) buf += x + 1
    buf.toList
  }
}






