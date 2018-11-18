package chapter_9

import java.io.{File, PrintWriter}

object Currying {
  //curried function is applied to multiple argument lists, instead of just one

  //example of a non curried function
  def plainOldSum(x: Int, y: Int) = x + y
  //apply as 2 list of parameter for your sum function
  def curriedSum(x: Int)(y: Int) = x + y
  //curriedSum actually creates two traditional function invocations back to back

  //you can use multiple parameter lists and currying to create new control structures in Scala
  def twice(op: Double => Double, x: Double) = op(op(x))

  //Create a functional template for a common pattern: open a resource, operate on it, and close the resource
  //uses a "loan pattern", which loans a resource to a function
  def withPrintWriter(file: File)( op: PrintWriter => Unit): Unit ={
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close
    }
  }
  //can use withPrintWriter to create a function thats prints contents of a file
  def printFile = withPrintWriter(new File("test.txt")) { writer =>
    writer.println(new java.util.Date)
  }
  //or use in a more concise manner
}
