import chapter_13.bobsdelights.Fruit

package object chapter_13 {
  //package objects are scoped to an entire package
  //think of it as a holder for methods of a package
  //showFruit will be accessible to any member of the chapter_13 project
  def showFruit(fruit: Fruit) = {
    import fruit._
    println(s"$name s are $color")
  }
}
