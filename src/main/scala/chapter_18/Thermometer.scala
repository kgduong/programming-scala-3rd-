package chapter_18

//It's sometimes useful to define a getter/setter without an associated field
class Thermometer {

  //the initializer "= _" assigns a zero value to celsius field
  var celsius: Float = _

  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_=(f: Float) = {
    celsius = (f - 32) * 5 / 9
  }
  override def toString = fahrenheit + "F/" + celsius + "C"
}


