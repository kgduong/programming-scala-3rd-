package chapter_25

//Integrating new sequences for RNA strands with scala collection library

//Every base is a case object that inherits from abstract class Base
abstract class Base
case object A extends Base
case object T extends Base
case object G extends Base
case object U extends Base

//defining a class for strands of RNA, which is conceptually a Seq[Base]
//  - since there are only 4 bases, we can identify with 2 bits, storing 16-bases as two-bit values in an integer
object Base {
  val fromInt: Int => Base = Array(A, T, G, U)
  //
  val toInt: Base => Int = Map(A -> 0, T -> 1, G -> 2, U -> 3)
}