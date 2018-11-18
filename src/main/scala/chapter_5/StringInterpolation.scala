package chapter_5

object StringInterpolation {
  //Interpolation allows you to embed expressions within string literals
  //Common use case is readable alternative to string concatenation
  val name = "reader"
  println(s"Hello, $name")

  val answer = s"The answer is ${5 * 5}"
  println(answer)

  //can also use raw string interpolation
  val rawString = raw"Helo/////w$answer////\\\\jlfkjlkdjlj"
  println(rawString)

  //Specify format using '%' symbol
  val pi = f"${math.Pi}%.5f"
  println(pi)

  //string interpolation is implemented by rewriting code at compile time
  //compiler treats any expression followed by open double quote as a string interpolator expression

}
