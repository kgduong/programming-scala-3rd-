package chapter_12

//Scala provides an ordered method that helps override comparison, reducing boilerplate code
//by using traits with some concrete methods, you can easily convert thin interfaces to rich interfaces
class Rational(val numer: Int, val denom: Int) extends Ordered[Rational] {
  def compare(that: Rational): Int = (this.numer * that.denom) - (that.numer * this.denom)
}


