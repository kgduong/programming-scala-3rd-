package chapter_9

object ByNameParameters {
  //Scala allows the use of pass by name parameters

  //Let's try to create an assertion construct called myAssert
  var assertionsEnabled = false
  def myAssert(predicate: () => Boolean) =
    if(assertionsEnabled && !predicate.apply())
      throw new AssertionError()
  //would call using
  myAssert(() => 5 > 3)

  //to make a by-name parameter, give a parameter type starting with "=>" rather than "() =>"
  def byNameAssert(predicate: => Boolean) =
    if(assertionsEnabled && !predicate)
      throw new AssertionError()
  //would call using
  byNameAssert(5 > 3)

  def boolAssert(predicate: Boolean) =
    if(assertionsEnabled && !predicate)
      throw new AssertionError()
  //A by-name type where the empty parameter list () is left out is only allowed for parameters.
  //because predicate in byNameAssert is of type "=> Boolean", the expression is not evaluated before the call to byNameAssert
  //  instead a function is created whose apply method will evaluate 5>3, and this function will be passed to byNameAssert

  //For example calling the function below will yield an exception
  boolAssert(5/0 == 0) // "5/0" will evaluate first throwing a divide by zero error
  byNameAssert(5/0 == 0) //will throw an assertion instead
}
