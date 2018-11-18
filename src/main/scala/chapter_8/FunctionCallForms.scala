package chapter_8

object FunctionCallForms {
  //Repeated Parameters
  //use an asterisk * to denote repeated parameter
  def echo(args: String*) =
    for (arg <- args) println(arg)
  //scala compiler treats args as an Array of defined type

  //default parameters
  def printTime(out: java.io.PrintStream = Console.out) =
    out.println("time = " + System.currentTimeMillis())


}
