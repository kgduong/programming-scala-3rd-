package chapter_6

class Rational(n: Int, d: Int){ //line up top here is the primary constructor
  /*
    Advantages of immutable objects:
      1. easier to reason about, as they do not have complex state spaces
      2. immutable objects can be passed freely while mutable objects need to make defensive copies
      3. no way for two threads concurrently accessing an immutable to corrupt it's state
      4. mutable objects make for better hash table keys
    Main disadvantage:
      - often requires large objects to be coped rather be done in place
      - can lead to a performance bottleneck
   */
  //auxiliary constructor for taking in different parameters
  def this(n: Int) = this(n, 1)//every auxiliary constructor requires this() as first statement
  //any constructor requires calling a this() that eventually bubbles to primary constructor

  //require is precondition for the primary constructor that d must be zero
  //if passed value is true, require will return normally
  require(d != 0)

  //g's initializer will execute before numer and denom because it appears first in source code
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n/g //creating fields to give access on other Rational object in add method
  val denom: Int = d/g //reason for that is because n and d are only accessible by object by which add was invoked

  //Scala's rules for operator precedence still applies for overloaded operators
  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational =
    new Rational(this.numer * that.numer, this.denom * that.denom)
  def *(i: Int): Rational =
    new Rational(this.numer * i, this.denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)
  def /(i: Int): Rational =
    new Rational(numer, denom * i)

  def lessThan(that: Rational) = this.numer * that.denom < that.numer * this.denom
  def max(that: Rational) = if (lessThan(that)) that else this
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)
  //toString is used by Scala REPL interpreter to display class information
  override def toString = s"$numer/$denom"
}
