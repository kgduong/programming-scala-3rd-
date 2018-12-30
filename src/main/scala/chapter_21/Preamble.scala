package chapter_21

import chapter_6.Rational

object Preamble {
  implicit def doubleToInt(x: Double) = x.toInt
  //Scala's Predef object which is implicitly imported into every Scala program defines implicit conversions
  //implicit def intToDouble(x: Int) = x.toDouble

  //Another use of conversions is the ease of operations between existing types
  //Example is the conversion below:
  implicit def intToRational(x: Int): Rational = new Rational(x, 1)
  //  - we convert ints to a rational so that ints can used operators with rational
  //  - i.e. " 1 + new Rational(3,4)"

  //This implicit conversions is also prevalent in Maps
  // -> operators are an implicit conversion
  implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A] = new ArrowAssoc(x)
}

