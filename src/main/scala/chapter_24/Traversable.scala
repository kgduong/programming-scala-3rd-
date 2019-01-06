package chapter_24

//Example of Traversable trait in Scala collections package
//Traversable provides a foreach definition that allows you to map through a collection
trait Traversable[Elem]{
  //Top of the collection hierarchy is trait Traversable

  //The only abstract operation is foreach
  def foreach[T](f: Elem => T)

  //Traversable also contains concrete methods, notably:
  /*
    - addition
    - map, flatMap, collect
    - Conversion: toIndexedSeq, toIterable, toStream
    - copyToBuffer, copyToArray
    - Size operations: isEmpty(), size(), hasDefinitiveSize()
    - Element retrieval: head, last, headOption, lastOption
   */

  //foreach is the basis for all operations in Traversable
}
