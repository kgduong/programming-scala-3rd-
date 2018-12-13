package chapter_16

object TypeInference {
  //Scala's type inference algorithm is flow based
  //inferencer first checks whether method m has known type
  //Some curried functions like that in higher ordered functions must have their types specified

  //The following method will have type inference
  def msortSwapped[T](xs: List[T])(less: (T,T) => Boolean): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs,ys) match {
      case (_, Nil) => xs
      case (Nil, _) => ys
      case (x::xs1, y::ys1) =>
          if(less(x,y)) x::merge(xs1, ys)
          else y::merge(xs,ys1)
    }
    val n = xs.length/2
    if(n == 0) xs
    else{
      val(left, right) = xs.splitAt(n)
      merge(msortSwapped(left)(less),msortSwapped(right)(less))
    }
  }
  //because the first parameter of msortSwapped is typed to Int, scala's type inference will follow for the second parameter

  //Scala's inference scheme suggest the following library design principle:
  //  when designing a polymorphic function that takes non-function arguments and a function
  //  Place the function argument last
  //This way the correct instance type can be inferred

  //if you're unsure of the type error messages of a polymorphic method, use type annotation to debug

}
