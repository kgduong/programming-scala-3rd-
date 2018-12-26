package chapter_20

//Abstract vals allows details in a subclass that are missing in a superclass
trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)

  val numer = numerArg / g
  val denom = numerArg / g

  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a%b)

  override def toString = numer + "/" + denom
}


//Revised version of RationalTrait but with lazy items for concrete fields
trait LazyRationalTrait{
  //lazy definitions order do not matter, as they get initialized on demand
  //These definitions only work if your code has no side effects and are really functional

  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g

  override def toString = numer + "/" + denom

  private lazy val g : Int ={
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }


  private def gcd(x: Int, y: Int): Int =
    if(y == 0) x
    else gcd(y, x % y)
}