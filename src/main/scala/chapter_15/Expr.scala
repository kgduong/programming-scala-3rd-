package chapter_15

abstract class Expr

//Case classes adds syntatic convenience
//  - you don't have to use "new" to construct a new object
//  -
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
