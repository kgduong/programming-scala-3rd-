package chapter_19

object VarianceAnnotation {
  //In Scala, generic types have default "nonvariant" subtyping

  //covariant or "flexible" subtyping => List[String] can be referenced as subtype of List[AnyRef]
  //you can demand covariance from your class/traits using [T+]
  //the generic class will be subtyped on it's data object
  trait IsCovariant[+T]{}


  //contravariant subtyping => if T is a subtype of S, then Queue[S] is subtype of Queue[T]
  //example: Cat extends Animal but AnimalPrinter extends CatPrinter because an Animal Printer can print any animal, but a Cat Printer cannot
  trait IsContravariant[-T]{}

  //functional programming is naturally covariant... until mutable data is introduced
  //Consider one-element cell which can be read or written
  class Cell[T](init: T){
    private[this] var current: T = init
    def get = current
    def set(x: T) = {current = x}
  }

  //As soon as a generic parameter type appears as the type of a method parameter, the containing class or trait may not be covariant in that type parameter

}
