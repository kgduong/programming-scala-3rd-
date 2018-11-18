//package chapter_8

object FunctionLiterals {
  //Function literals can be expressed with "=>"
  val increase = (x: Int) => x + 1
  val someNumbers = List(10, 11, 12, 13, 14, 15)

  //You can use underscores as placeholder syntax for one or more parameters
  someNumbers.filter(_ > 10)
  def sum(a: Int, b: Int, c: Int) = a + b + c

  //partially applied function
  val partialSum = sum _ //partialSum now becomes a function value that takes a reference to sum
  //partial sum has an apply method which takes 3 arguments
  //thus partialSum(1,2,3) is really partialSum.apply(1,2,3)

  //can also apply it to only some of the arguments
  val partialSum10And3 = sum(10, 3, _ :Int)

  //expressions where you leave off all parameters, instead of println _ simply use println
  someNumbers.foreach(println _)
  someNumbers foreach println

}
