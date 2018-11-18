package chapter_8

object Closures {
  //Function literals can have free variables and bound variables
  //  -free variables => the function literal does not give meaning to
  //  -bound variables => define by function's lone parameter

  //Closure => a function value(object) thats created at runtime from a function literal
  val more = 1
  val addMore = (x: Int) => x + more
  //a function literal with no free variables is a "closed term", i.e. x:Int => x + 1
  //a closure is function literal that requires a binding a a free variable, in this case more

  //closures capture variables, but not the values that they refer too
  //hence result of addMore will change if more changes
  //closures can also alter the values of the free variable

  //example of a function that creates a closure
  def makeIncreaser(more: Int) = (x: Int) => x + more
}
