package chapter_20

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  val current: T
}

class Concrete extends Abstract {
  type T = String //T is now an alias for type String
  def transform(x: String) = x + x
  val initial = "hi"
  val current = initial
}


