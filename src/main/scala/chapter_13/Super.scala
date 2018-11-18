package chapter_13

class Super {
  protected def f() = println("f")
  private[chapter_13] val object_private = "object_private is private to scope of chapter_13 project"
  private[this] val this_instance_only = "object is private to other instances of the same class"
}
class Sub extends Super{
  f() //protected methods can only be accessed by a derived class
}
private class Other{
  //(new Super).f() //f is not accessible in this case
  val grab_object_private = (new Super).object_private
}