package chapter_5

object OperatorMethods {
  //operators in scala are actually just ordinary method calls
  val sum = 1 + 2 == 1.+(2)
  //common operators are overloaded, i.e. + Long or + FLoat
  val sumLong = 1 + 2L == 1.+(2l)

  //you can use any method in operator notation
  val s = "Hello World!"
  println(s indexOf '0')
  //when using operator notation for a method with multiple args, use parentheses
  println(s indexOf ('o', 5))

  //operators can be prefix or post fix or infix
  //prefix and postfix operators are unary, they take just one operand

  //prefix operators have "unary_" as a prefix in their function name
  //i.e. -2.0
  val negativeTwo = 2.0.unary_- //-2.0
  //only identifiers that can be prefix operators are +,-,!,~


  //postfix operators take no argument when invoked without a dot or parentheses
  println(s toLowerCase)
}
