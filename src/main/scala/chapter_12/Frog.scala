package chapter_12

class Animal

class Frog extends Animal with Philosophical {
  override def toString: String = "green"

  override def philosophize (): Unit = println(s"It ain't easy being ${toString}!")
}
