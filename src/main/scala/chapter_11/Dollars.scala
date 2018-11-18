package chapter_11

//Defining our own value class "Dollars"
//Value classes can only have one parameter and only has def inside
//no other class can extend value class, and it cannot override equals or hashCode
class Dollars(val amount: Int) extends AnyVal {
  override def toString: String = "$" + amount
  //Dollars is of type Dollars in Scala source code
  //compiles to Int in Java bytecode
}
