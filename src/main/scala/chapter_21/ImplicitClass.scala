package chapter_21

case class Rectangle(width: Int, height: Int)

object Rectangle{
  //Implicit class is a class where the compiler generates an implicit conversion from the class's
  // constructor parameters to the class itself
  // by importhing RectangleMaker you can construct a new code with " 3 x 3 "
  implicit class RectangleMaker(width: Int){
    def x(height: Int) = Rectangle(width, height)
  }

  //Since Ints have no method named x, the compiler will look for an implicit conversion
  //In this case, it'll be RectangleMaker which calls x to create a new Rectangle
}