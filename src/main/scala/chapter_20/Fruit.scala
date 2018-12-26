package chapter_20

//Abstract val declaration
//Best used for a val definition that are concrete method and definitions
abstract class Fruit {
  val v: String //v for value
  def m: String //m for method
}

abstract class Apple extends Fruit{
  val v: String
  val m: String
  //def v: String will result in error because of errors
}

//abstract var declares just a name and a type but not an initial value
trait AbstractTime{
  var hour: Int
  var minute: Int
}

//Remember that vars come packaged with getter and setter emthods
trait AbstractTimeBoilerPlate{
  def hour: Int //getter for hour
  def hour_=(x: Int) //setter for hour
  def minute: Int //getter for minute
  def minute_=(x: Int) //setter for minute
}

