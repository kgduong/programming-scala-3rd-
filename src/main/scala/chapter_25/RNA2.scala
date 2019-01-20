package chapter_25
import collection.{IndexedSeqLike, mutable}
import collection.mutable.{ArrayBuffer}
import collection.generic.CanBuildFrom


//RNA2 inherits from IndexedSeq and IndexedSeqLike
//IndexedSeqLike implements all concrete methods of IndexedSeq in an extensible way
final class RNA2 private (
  val groups: Array[Int],
  val length: Int)
  extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA2]{
  //return type of methods like take, drop, filter is the second type parameter passed to IndexedSeqLike
  //IndexedSeqLike bases itself using a new Builder abstraction which creates a builder of the right kind

  import RNA2._
  //returns a builder of type Builder[Base, RNA2]
  //  - Constructs an ArrayBuffer, itself is a Builder[Base, ArrayBuffer]
  //  - Transform arrayBuffer using mapResult to create a RNA2 builder
  //  - mapResult, expects a function that transform ArrayBuffer to RNA2
  //      - this function is supplied by companion object RNA2.fromSeq
  override def newBuilder =
    new ArrayBuffer[Base] mapResult fromSeq

  def apply(idx: Int): Base = {
    if(idx < 0 || length <= idx) throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }

  /*
  If newBuilder was not overridden in our implementation,
   */
}

object RNA2{
  //Number of bits necessary to represent group
  private val S = 2

  //Number of groups that fit in an Int
  private val N = 32/S

  //Bitmask to isolate a group, by isolating lowest S bits in a word
  private val M = 1 << S - 1

  def fromSeq(buf: Seq[Base]): RNA2 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for(i <- 0 until buf.length){
      //extracts an integer value from group arrays using right shift ">>"  and mask "&"
      groups(i/N) |= Base.toInt(buf(i)) << (i % N * S)
    }
    //Calls RNA1's private constructor, since this is it's companion object
    new RNA2(groups, buf.length)
  }

  //Converts a sequence of Base items to RNA2 sequence
  def apply(bases: Base*) = fromSeq(bases)

}
