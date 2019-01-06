package chapter_24

//Iterable is trait that provides an iterator which yields element one by one for a collection
trait Iterable[Elem] extends Traversable[Elem]{
  def iterator()

  //all methods in this trait are defined in terms of abstract method, iterator which yield elements one by one
  def foreach[U](f: Elem => U): Unit = {
    val it = iterator()
    //while(it.hasNext) f(it.next)
  }
}
