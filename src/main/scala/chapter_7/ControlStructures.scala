package chapter_7

import java.io.File

object ControlStructures {
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while(a != 0){
      val temp = a
      a = b % a
      b = temp
    }
    b
  }
  def gcdFunctional(x: Long, y: Long): Long = {
    if(x % y == 0) x else gcdFunctional(y, x % y)
  }

  def doWhileLoopExample(x : Int) = {
    val line = ""
    var i = 0
    //do while loop will run first before checking clause
    do {
      println(s"Iterate: $i")
      i += 1
    }while(x > i)
  }
  //In Scala, assignments will always result in Unit value
  // (var line = readLine()) == Unit

  def ls() = {
    val filesHere = new File(".").listFiles
    for(file <- filesHere)
      println(file)
  }

  def usingRange(n: Int) = {
    //regular for loop up to n
    for(i <- 1 to n)
      println(s"Iteration: $i")
    //for loop for n - 1
    for(i <- 1 until n)
      println(s"Iteration2: $i")

    //applying a filter within your for loop
    for(i <- 1 until n if i % 2 == 1)
      println(s"Iteration odds only: $i")
  }

  def fileLines(file: File) = scala.io.Source.fromFile(file).getLines().toList
  def grep(pattern: String) ={
    //using a nested forloop with filters in scala
    val filesHere = new File(".").listFiles()
    for(
    file <- filesHere
    if file.getName.endsWith(".scala");
    line <- fileLines(file)
    if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)
  }

  //Example of an function that generates an array of Files using yield keyword
  def scalaFiles =
    for{
      file <- new File("./src/main/scala/chapter_7/").listFiles
      if file.getName.endsWith(".scala")
    }yield file


  //Throwing exceptions in Scala
  def throwException(n: Int) = {
    val half = if(n % 2 == 0) n / 2 else throw new RuntimeException("n must be even")
  }
  //In Scala, any finally statement with an explicit return or thrown exception will overrule rest
  //i.e. f will always return 2
  def f(): Int = try return 1 finally return 2
  //where as g will return 1
  def g(): Int = try 1 finally 2
  //Treat finally clauses as a method to ensure some side effect happens

}
