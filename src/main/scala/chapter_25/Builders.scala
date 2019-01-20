package chapter_25



abstract class Builder[-Elem, +To]{
  //Design was to reduce code duplication, which could lead to inconsistencies over time
  //Principal design objective is to avoid duplication, defining every operation in as few places as possible
  //Created collection "templates" that can be flexibly inherited from individual base classes

  //Almost all collection operations are implemented in terms of traversal and builders
  def +=(elem: Elem): this.type
  def result(): To //returns a collection from a builder
  def clear()
  def mapResult[NewTo](f: To => NewTo): Builder[Elem, NewTo] //Refers to another builder for assembling elements of a collection

  //"same-result-type" principle: Wherever possible, a transformation method on a collection will yield a collection of the same type
  //  - i.e. applying filter on a list should give a list, a map should give a map
}

//TODO: Review chapter 25.2 regarding collections integration
