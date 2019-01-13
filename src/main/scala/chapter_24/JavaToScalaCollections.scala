package chapter_24

import scala.collection.JavaConverters
import scala.collection.mutable.ArrayBuffer

class JavaToScalaCollections {
  //Syntax like: `List(1,2,3)` and `Set('A', 'B', 'C')` are really calling apply() on some object
  //There is a companion object that implements apply() and empty()
  /*
    Descendants of Seq traits also provide various factory methods, such as concat, fill, and tabulate
   */

  //Scala libraries place much more emphasis on immutable collections,
  //Scala provides implicit conversions between all collection types in JavaConversion object
  import collection.JavaConverters._
  val javaList: java.util.List[Int] = JavaConverters.bufferAsJavaList(ArrayBuffer(1,2,3))
  //Creates "wrapper" object that forwards all operations to underlying collection
  //There is never a conversion between scala objects to java objects & vice-versa

  //Since Java does not distinguish mutable and immutable collections, so any mutable operations will yield Unsupported Operation Exception
}


