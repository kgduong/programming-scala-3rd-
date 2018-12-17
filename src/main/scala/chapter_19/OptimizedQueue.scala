package chapter_19

//Optimized Queue implementation in regards to covariance and contravariance
class OptimizedQueue[+T] private (private[this] var leading: List[T],
                                  private[this] var trailing: List[T]){
  //Scala variance check contains special case for object private definitions
  //Such definitions are omitted when a type parameter occurs only in positions with the same variance classification
  //if you left out "[this]" qualifier, the code would not compile

  private def mirror() =
    if(leading.isEmpty){
      while(!trailing.isEmpty){
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }

  def head: T = {
    mirror()
    leading.head
  }

  def tail: OptimizedQueue[T] = {
    mirror()
    new OptimizedQueue(leading.tail, trailing)
  }

  def enqueue[U >: T](x: U) =
    new OptimizedQueue[U](leading, x :: trailing)
}
