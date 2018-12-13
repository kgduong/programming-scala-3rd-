package chapter_18

//In Scala, every var that is a non-private member of some object implicitly defines a getter and setter
class Time {

  //because we created a var hour, a getter "hour" and setter "hour_=" is generated
  var hour = 12
  var minute = 0
}


//The definition above is the same as TimeVerbose below
class TimeVerbose {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_=(x: Int) = { h = x}

  def minute: Int = m
  def minute_=(x: Int) = {m = x}

}


//An aspect of the verbose definition is that you interpret operations as you like
//With this specific implementation, you can place required aspects in your setters
//  example would be "required" which catches all illegal values
class TimeVerboseSpecified {

  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_=(x: Int) = {
    require(0 <= x && x < 24)
    h = x
  }

  def minute = m
  def minute_= (x: Int) = {
    require(0 <= x && x < 60)
    m = x
  }
}

