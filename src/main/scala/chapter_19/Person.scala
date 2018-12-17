package chapter_19

//Creating an ordered person for use of our merge sort
class Person (val firstName: String, val lastName: String) extends Ordered[Person]{

  //Ordered[Person] is a trait that must override compare
  def compare(that: Person) = {
    val lastNameComparison = lastName.compareToIgnoreCase(that.lastName)
    if(lastNameComparison != 0) lastNameComparison
    else {
      firstName.compareToIgnoreCase(that.firstName)
    }

  }

  override def toString = firstName + " " + lastName
}


object Person{
  //"[T <: Ordered[T]]" specifies an upper bound indicating type parameter T, has an upper bound Ordered[T]
  //  -this means that the element type of the list passed to orderedMergeSort  must be a subtype of Ordered
  def orderedMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil,_) => ys
        case (_, Nil) => xs
        case(x :: xs1, y :: ys1) =>
          if(x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
    }
    val n = xs.length/2
    if(n == 0) xs
    else{
      val(ys,zs) = xs splitAt(n)
      merge(orderedMergeSort(ys), orderedMergeSort(zs)) //split at N and order the merge
    }
  }
}