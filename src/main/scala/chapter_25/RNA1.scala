package chapter_25


final class RNA1 private(val groups: Array[Int], val length: Int)
  extends IndexedSeq[Base]{ //Note that it's constructor is private, so only case object RNA1 can construct an RNA1 sequence
  import RNA1._
  def apply(idx: Int): Base = {
    if(idx < 0 || length <= idx) throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }

  //Calling take() on RNA1 returns a Vector[Base], since that's the default implementation for IndexedSeq
  //The default implementation would apply for all operations inherited from IndexedSeq
  //Could override take() function, but design would be inconsistent for all patterns

}

object RNA1{
  //Number of bits necessary to represent group
  private val S = 2

  //Number of groups that fit in an Int
  private val N = 32/S

  //Bitmask to isolate a group, by isolating lowest S bits in a word
  private val M = 1 << S - 1

  def fromSeq(buf: Seq[Base]): RNA1 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for(i <- 0 until buf.length){
      //extracts an integer value from group arrays using right shift ">>"  and mask "&"
      groups(i/N) |= Base.toInt(buf(i)) << (i % N * S)
    }
    //Calls RNA1's private constructor, since this is it's companion object
    new RNA1(groups, buf.length)
  }

  //Converts a sequence of Base items to RNA1 sequence
  def apply(bases: Base*) = fromSeq(bases)

}

