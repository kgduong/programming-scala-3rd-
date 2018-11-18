package chapter_7

object MatchExpressions {
  //match expressions allow you to select from a number of alternatives
  def matchExample(args: Array[String]) = {
    val firstArg = if(args.length > 0) args(0) else ""
    firstArg match {
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh???")
    }
  }

  def breakAndContinueSubstitute(args: Array[String]) = {
    var i = 0
    var foundIt = false

    while(i < args.length && !foundIt){
      if(!args(i).startsWith("-")){
        if(args(i).endsWith(".scala"))
          foundIt = true
      }
      i += 1
    }
  }

  //recursive search from array
  def searchFrom(args: Array[String], i: Int): Int =
    if(i >= args.length) -1
    else if (args(i).startsWith("-")) searchFrom(args, i+1)
    else if (args(i).endsWith(".scala")) i
    else searchFrom(args, i + 1)
}
