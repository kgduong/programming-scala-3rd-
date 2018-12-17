package chapter_19

//Revision of FunctionalQueue, with privacy
//private word after PrivateFunctionalQueue creates a private primary constructor
class PrivateFunctionalQueue[T] private( private val leading: List[T],
                                         private val trailing: List[T]){
  //This private primary constructor can only be accessed by class and it's companion object

  //We can create auxiliary constructors to call private constructor
  def this() = this(Nil, Nil) //creates empty queue with empty list for leading and trailing
  def this(elems: T*) = this(elems.toList, Nil) //another constructor but takes parameters
}


//Creating a companion object for PrivateFunctionalQueue with factory methods
//Companion object can call the private constructor of original class
object PrivateFunctionalQueue{
  //constructs a queue with initial elements 'xs'
  def apply[T](xs: T*) = new PrivateFunctionalQueue[T](xs.toList, Nil)
}
