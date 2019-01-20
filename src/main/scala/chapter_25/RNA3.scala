package chapter_25

import scala.collection.IndexedSeqLike
import scala.collection.generic.CanBuildFrom
import scala.collection.mutable.ArrayBuffer

/*
  Final version of our RNA collection class, which implements:
    - IndexedSeqLike => to apply filter() and such methods to return RNA sequences
    - CanBuildFrom => to implement map() and ++() methods to return RNA sequences
 */
final class RNA3 private(val groups: Array[Int], val length: Int)
  extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA3]{
  import RNA3._

  //Mandatory re-implementation of `newBuilder` in `IndexedSeqLike`
  override protected[this] def newBuilder= RNA3.newBuilder

  //Mandatory implementation of `apply` in `IndexedSeq`
  def apply(idx: Int): Base = {
    if(idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx/N) >> (idx % N * S) & M)
  }

  //Optional re-implementation of foreach, to make it more efficient
  //  - implements loops over collections, with other collection methods relying on foreach
  //  - apply the unpacking of our strands as early as possible
  override def foreach[U](f: Base => U): Unit = {
    var i,b = 0
    while(i < length){
      b = if(i % N == 0) groups(i/N) else b >>> S
      f(Base.fromInt(b & M))
      i += 1
    }
  }
}

object RNA3{
  //Number of bits necessary to represent group
  private val S = 2

  //Number of groups that fit in an Int
  private val N = 32/S

  //Bitmask to isolate a group, by isolating lowest S bits in a word
  private val M = 1 << S - 1

  def fromSeq(buf: Seq[Base]): RNA3 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for(i <- 0 until buf.length){
      //extracts an integer value from group arrays using right shift ">>"  and mask "&"
      groups(i/N) |= Base.toInt(buf(i)) << (i % N * S)
    }
    //Calls RNA1's private constructor, since this is it's companion object
    new RNA3(groups, buf.length)
  }

  //Converts a sequence of Base items to RNA3 sequence
  def apply(bases: Base*) = fromSeq(bases)

  //newBuilder that calls an ArrayBuffer to construct our RNA3 sequence
  //the newBuilder function in RNA3 class simply maps to this function in the companion object
  def newBuilder =
    new ArrayBuffer[Base].mapResult(fromSeq)

  //Create a CanBuildFrom implicit instance
  //Given an RNA strand and a element type Base, build another collection is again an RNA strand
  implicit def canBuildFrom: CanBuildFrom[RNA3, Base, RNA3] =
    new CanBuildFrom[RNA3, Base, RNA3]{
      //Creates a builder for RNA3 collection of element Base
      def apply()= newBuilder
      //Creates a builder from a previous RNA3 sequence
      def apply(from: RNA3) = newBuilder
    }
}

/*
  Code above, implements all collection methods at their natural types RNA3
    - Requires you to know where to place newBuilder factories and canBuildFrom implicits
    - newBuilder implicit constructs new RNA3 collections when needed for map, ++, and etc operations
    - Automatically defined operations with relatively little code
    -
 */