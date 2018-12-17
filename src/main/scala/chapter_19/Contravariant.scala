package chapter_19

//Cases are contravariance is natural tends to be in the form of containers
object Contravariant {
  //consider the following trait OutputChannel
  trait OutputChannel[-T]{
    def write(x: T)
  }
  /*
    An example would be OutputChannel[String] and OutputChannel[AnyRef]
      - it's safe to write OutputChannel[String] as with OutputChannel[AnyRef]
      - it's unsafe to use an operation OutputChannel[AnyRef] on OutputChannel[String]
   */

  //Liskov Substitution Principle => safe to assume type T is a subtype of a type U
  //principle holds if T supports the same operations as U, and all of T's operations require less and provide more than the corresponding operations in U

  //An example would be Function type (A => B) in Scala
  //  - Function is contravariant in the argument type S and covariant in result type T
  trait KyleFunction1[-S, +T]{
    //contravariant to type S, because arguments require a stricter bound
    def apply(x: S): T
  }
}



//Demonstration of function type parameter variance
class Publication(val title: String)
class Book(title: String) extends Publication(title)

object Library{
  val books: Set[Book] = Set(new Book("Programming in Scala"),
                              new Book(title = "Walden"))
  def printBookList(info: Book => AnyRef) = {
    books.foreach(book => println(info(book)))
  }

  object Customer extends App{
    def getTitle(p: Publication): String = p.title
    Library.printBookList(getTitle)
    //getTitle passes the compiler test because functions are covariant for result types
    //getTitle's result is of type String, which is covariant to AnyRef

  }

  //Code here compiles because Publication => String is a subtype of Book => AnyRef
}