package chapter_19

//creating a type abstraction for FunctionalQueue
trait QueueAbstraction[T]{
  def head: T
  def tail: QueueAbstraction[T]
  def enqueue(x: T): QueueAbstraction[T]
}

//Using a companion object for Queue
//Here we implement the functional queue through the companion object
//We hide the class itself and only export the trait that reveals the interface
object QueueAbstraction{
  def apply[T](xs: T*): QueueAbstraction[T] = new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[T](private val leading: List[T], private val trailing: List[T]) extends QueueAbstraction[T]{
    def mirror = if(leading.isEmpty) new QueueImpl[T](trailing.reverse, Nil)
                                          else this

    def head: T = mirror.leading.head

    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl[T](q.leading.tail, q.trailing)
    }

    def enqueue(x: T) = new QueueImpl[T](leading, x :: trailing)


  }
}
