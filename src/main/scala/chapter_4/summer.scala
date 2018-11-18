import CheckSumAccumulator.calculate

//entry point to any scala application
//a standalone singleton object with a main method
// that takes an Array[String] with result Unit
object Summer{
  def main(args: Array[String]): Unit ={
    args.foreach(arg => println(arg + ": " + calculate(arg)))
  }
}


//Scala implicitly imports members of packages java.land and scala into every source file
//Predef which resides in package scala contains many useful methods like println and assert
//script files must end in a result expression

//you can manually compile using scalac