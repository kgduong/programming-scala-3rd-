//Singleton Objects

//When a singleton object shares the same name with a class, it's called a class's companion object
//Companion objects and companion classes can access each other's private members
import scala.collection.mutable

//companion class
class CheckSumAccumulator{
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1
}

//companion object
//treat companion objects as home to any static method

object CheckSumAccumulator{
  private val cache = mutable.Map.empty[String, Int]

  //calculate which takes a string and calculates checksum for characters in string
  def calculate(s: String): Int =
    //if our cache already contains string, return sum from the cache
    if(cache.contains(s))
      cache(s)
    else {
      //call num sum
      val acc = new CheckSumAccumulator()
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}

//singleton objects are first class objects, meaning their name is a "name tag" to the object
//singleton objects can mix in superclasses and mixed-in traits, so you can inboke certain methods
//singleton object is initialized the first time some code accesses it
