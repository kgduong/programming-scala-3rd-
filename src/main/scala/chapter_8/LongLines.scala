package chapter_8
import scala.io.Source

//Most common way to define a function is as a member of some object, called methods
//LongLines reads a file and prints out all lines exceeding a certain width
object LongLines {
  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for(line <- source.getLines()) //getLines is an iteration
      processLine(filename, width, line)
  }

  private def processLine(filename: String, width: Int, line: String) ={
    if (line.length > width)
      println(s"$filename : ${line.trim}")
  }

  //scala provides nested functions as an alternative to private functions
  def processFileViaNestedFunctions(filename: String, width: Int) = {
    //we can remove filename as a parameter
    def processLine(line: String) = {
      if(line.length > width)
        println(s"$filename : ${line.trim}")
    }
    //refactored processLine as a nested function
    val source = Source.fromFile(filename)
    for(line <- source.getLines())
      processLine(line)
  }

  //Scala has first-class-functions, which can be defined, called, creates as unnamed literals, and passed as values
  //Function literals are compiled into a class called function value at runtime
  //Function literals exists in source code, while function values exists as object at runtime

  //Many scala libraries harness the power of function literals
  //Example would be the `foreach` method in all collections
  //Function literals uses "target typing" parameters of a literal can be left off based on the collection it refers too

  //you can also use underscores "_" as placeholders for one or more parameters as long as each parameter only appears once
  //the underscore is a blank expression that needs to be filled in
}
