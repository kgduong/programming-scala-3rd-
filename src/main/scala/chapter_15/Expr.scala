package chapter_15

//Sealed abstract classes cannot be inherited outside of file
//This allows your pattern match to be deterministic
sealed abstract class Expr

//Case classes adds syntatic convenience
//  - you don't have to use "new" to construct a new object, because case classes have a factory method implemented
//  - All parameters of a case class get an implicit val prefix
//  - toString, hashCode, and equals get "natural" implementation
//  - copy method that makes modified copies of the object

case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

case object Expr{
  def simplifyTop(expr: Expr) = expr match {
    case UnOp("-", UnOp("-", e)) => e //Double Negation
    case BinOp("+", e, Number(0)) => e //Adding Zero
    case BinOp("*", e, Number(1)) => e //Multiplying by one
    case _ => expr
  }

  def catchBinOpOnly(expr: Expr) = expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operations")
    case _ => println("It's something else.")//using _ to match to any object that's not BinOp
  }

  //below we use constant pattern match to have discrete cases
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "The empty list"
    case _ => "something else"
  }

  //pattern matching can be used on variables as well to test for matched objects
  def variablePatternMatch(expr: Int, somethingElse: Int) = expr match{
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  //we can use pattern match to both a variable and a constant
  import math.{Pi, E}
  val pi = math.Pi
  def piMatch = E match {
    case Pi => "strange math? Pi = " + Pi
    case `pi` => "strange math? pi = " + pi
    case _ => "OK" //cannot wildcard operator, since we're matching to a variable pi
  }
  //if needed, you can use backticks `` to state that you're using a constant

  //you can use pattern matching on a list or sequence as well
  def matchSequence(expr: List[Int]) = expr match {
    case List(0, _*) => println("found the list")
    case _ => "Not found"
  }
  //can also be used with tuples as well

  //Typed pattern allows for easy type tests and type casts
  def generalSize(x: Any) = x match {
    //Scala prefers pattern matching over type test&&casting as it's much more verbose
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  //variable binding match, allows you to use a variable with a specific pattern
  def variableBindingMatch(expr: Expr)= expr match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>
  }
}