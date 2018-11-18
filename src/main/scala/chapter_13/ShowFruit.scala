//easy access to Fruit
import chapter_13.bobsdelights.Fruit
//easy access to all members of bobsdelights
import chapter_13.bobsdelights._
//easy access to all members of Fruits
import chapter_13.bobsdelights.Fruits._

object ShowFruit{
  def showFruit(fruit: Fruit) = {
    //importing all members of fruit class, meaning we can use name and color byu their own key
    import fruit._
    println(name + "s are " + color)
  }
}

/*
  Scala's flexible imports have 3 main principles
  1. may appear anywhere
  2. may refer to objects(singleton or regular) in addition to packages
  3. let you rename or hide some of the imported members
 */

//Can rename imports as well
//Our apple import here is renamed to McIntosh
import Fruits.{Apple => McIntosh}


/*
  Scala's Implicit Imports:
  There are 3 Scala imports that always occur on top of any Scala project
  import java.lang._ //everything in java.lang package
  import scala._ //everything in scala project
  import Predef._ //everything in Predef object
 */

