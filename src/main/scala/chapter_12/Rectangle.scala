package chapter_12

class Point(val x: Int, val y: Int)

trait Rectangular{
  def topLeft: Point
  def bottomRight: Point
  def left: Int = topLeft.x
  def right: Int = bottomRight.x
  def width: Int = right - left
}

class Rectangle (val topLeft: Point, val bottomRight: Point) extends Rectangular {
  //Inherits all concrete methods of Rectangular
}
