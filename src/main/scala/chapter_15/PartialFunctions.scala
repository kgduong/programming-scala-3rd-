package chapter_15

object PartialFunctions {
  //A case of sequences gives you a partial function
  //Partial functions that are given a data type it does not support will result in a runtime exception
  val second: PartialFunction[List[Int], Int] = {
    case x::y::_ => y
  }

  //partial functions have a "isDefinedAt" to test whether the function is defined for a particular value

}
