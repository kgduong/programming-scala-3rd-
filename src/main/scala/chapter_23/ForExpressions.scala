package chapter_23

object ForExpressions {
  case class Person(name: String, isMale: Boolean, children: Person*)

  //Generic for-loop expression
  def genericForLoop(persons: Person*) = {
    //for expressions come in the form for(seq) yield expr
    for(p <- persons; n = p.name; if n startsWith "To")
      yield n
  }

  case class Book(title: String, authors: String*)
  //You can use the for expression similar a sql statement
  def queryWithForLoop(books: Book*) = {
    //Get all book titles with an author named "Gosling"
    val b1 = for(b <- books; a <- b.authors
                        if a startsWith "Gosling")
                      yield b.title

    //Find all titles with "Program"
    val b2 = for(b <- books if (b.title indexOf "Program") >= 0)
                    yield b.title
  }

  //example of removing duplicates
  def removeDuplicates[A](xs: List[A]): List[A] = {
    if(xs.isEmpty) xs
    else
      xs.head :: removeDuplicates(xs.tail filter(x => x != xs.head)) //remove the duplicates here
      //Can also be equivalently expressed with a for loop
      xs.head :: removeDuplicates(
        for(x <- xs.tail if x != xs.head) yield x
      )
  }

  //TODO: Review 23.4 for translating between for-expression and higher order functions


}
