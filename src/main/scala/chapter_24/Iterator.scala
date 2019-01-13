package chapter_24

class Iterator2 {
  //Not a collection, but a method to access elements one by one
  //Two basic operations are next and hasNext
  //iterators provide analogues for most methods you find in traversable

  //Iterators provid a map method, returning a new iterator
  val it = Iterator("a", "number", "of", "words")
  val it2 = it.map(_.length)

  println(it2.hasNext)

  //Iterators behave like collections if you never access an iterator again after invoking a method on it
  //This is represented in scala trait TraversableOnce, a common supertrait of Traversable and Iterator

  //Buffered Iterators
  //  - an instance of BufferedIterators trait, which provides an extra method head()
  //  - Head() => will return its first element, but will not advance the iterator

  //Example of using a buffered iterator that skip empty words
  def skipEmptyWords(it: BufferedIterator[String]) =
    while(it.head.isEmpty) it.next


}
