package chapter_24

class Arrays {
  //Scala arrays correspond one-to-one with Java arrays
  //Scala arrays can be generic and are compatible with Scala sequences
  val a1 = Array(1,2,3,4,5,6)
  val a2 = a1 map (_ * 5)

  //Scala compatibility with Java Arrays is derived from a wrapper around the array
  val seq: Seq[Int] = a1 //seq is now WrappedArray
  //This is an implicit conversion from seq => Array and Array => Seq

  //Another implicit conversion is ArrayOps, which gives sequence methods to arrays
  val ops:  collection.mutable.ArrayOps[Int] = a1 //ArrayOps is another wrapper for Java Arrays

  //ArrayOps conversion has higher priority than WrappedArray
  //  - ArrayOps conversion is defined in Predef object
  //  - WrappedArray conversion is defined in LowPriorityImplicits


  //How Scala handles generics for Arrays, *since Java arrays can't have generics???
  //  - Scala performs type tests that determines actual array type, then performs correct type operation
  //  - These extra tests do slow down performance
  //  - Scala uses scala.reflect.ClassTag, which describes "erased type" of a given type
  //  - The compiler is passed the class tag using a context bound, to determine Type for the Array

  //example of class tag being passed
  import scala.reflect.ClassTag
  def evenElems[T: ClassTag](xs: Vector[T]): Array[T] = {
    //compiler looks for ClassTag of Type T to generate new Array[T]
    val arr = new Array[T]((xs.length + 1) / 2) //create a new array of type T with half length of xs
    for(i <- 0 until xs.length by 2)
      arr(i/2) = xs(i) //add all even elements of xs
    arr
  }

  //Can apply the ClassTag logic further using another implicit class Tag
  def wrap[U: ClassTag](xs: Vector[U]) = evenElems(xs)
  //ClassTag detects type U from Vector, then passes type to xs in evenElems


}
