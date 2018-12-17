package chapter_19


trait Queue[T]{
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]
}

//Functional Queue is a data structure with 3 operations
/*
  head => returns first element of the Queue
  tail => returns a queue without its head
  enqueue => returns a new queue with a given element appended
 */
class FunctionalQueue[+T](private val leading: List[T], private val trailing: List[T]){
  //Queues are extended at the end using enqueue
  //Ideally, queue should operate in constant time

  //Our implements represents a queue using 2 lists, leading and trailing
  //leading => elements towards front, trailing => elements in back in reversed order


  private def mirror =
    //only linear if the queue itself is empty, constant otherwise
    if(leading.isEmpty) new FunctionalQueue[T](trailing.reverse, Nil)
    else this


  //head and tail may call mirror, but as the queue grows it's less likely to call linear
  //assuming head, tail, enqueue appear at the same frequency, amortized complexity is constant
  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new FunctionalQueue[T](q.leading.tail, q.trailing)
  }

  //We can generalize enqueue by making it polymorphic
  //  use "[U >: T]" to give a lower bound
  //  T is a lower bound of type U, hence U must be a supertype of T
  /*
    For example, suppose there is a class Fruit, with two subclasses Apple and Oranges
    One can now append an Orange to a Queue[Apple] and result will be Queue[Fruit]
   */
  def enqueue[U >: T](x: U) = new FunctionalQueue[U](leading, x :: trailing)
}



//Simple approach to implement a functional queue with a list
class SlowAppendQueue[T](elems: List[T]) extends Queue[T]{
  def head = elems.head
  def tail = new SlowAppendQueue(elems.tail)
  def enqueue(x: T) = new SlowAppendQueue(List(x)) //O(n) operation to enqueue
}

//Another implementation using a reversed list
class SlowHeadQueue[T](smele: List[T]) extends Queue[T]{
  //smele is elems reversed
  def head = smele.last
  def tail = new SlowHeadQueue[T](smele.init)
  def enqueue(x: T) = new SlowHeadQueue[T](x :: smele)
}


