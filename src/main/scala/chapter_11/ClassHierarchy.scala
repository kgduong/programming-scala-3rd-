package chapter_11

object ClassHierarchy {
  //Super class of any class in Scala is Any
  //While Nothing and Null are bottom classes
  //Every class in scala can be compared using ==, !=, and equals()

  //AnyVal and AnyRef are the 2 subtypes of Any
  //AnyVal is the subclass is to all value classes in Scala {Byte, Short, Char, Int, Long, Float, Double, Boolean, and Unit}
  //AnyVal classes have implicit conversions between different class types
  //AnyVal classes have Rich versions which hold defined methods for implicit conversions

  //AnyRef
  //Base class for all reference classes in Scala
  //Can use java.lang.Object and AnyRef interchangeably in Scala


  def isEqual(x: Int, y: Int): Boolean = x == y
  def isEqual(x: Any, y: Any): Boolean = x == y
  //applying both variations of isEqual will give the same result in Scala
  //Scala's "==" operator is natural equality for value types, and is treated as an alias of equals() for reference types

  //AnyRef defines an "eq" method that checks for reference equality
  val x = new String("xy") //create new reference String type
  val y = new String("xy") //create another reference type
  val naturalEquality: Boolean = x == y
  val referenceEquality: Boolean = x eq y

  //Bottom Types
  //Scala has two bottom classes: Null and Nothing

  //Null => type of the null reference
  //subclass of every reference class(i.e. any class that inherits from AnyRef)
  //cannot assign Null to a value type

  //Nothing = very bottom of Scala's class hierarchy, a subtype of every other type
  //One use of Nothing is to signal abnormal termination
  //Return type of errors is Nothing to signal method will not return normally
}
