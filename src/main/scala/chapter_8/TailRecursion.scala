package chapter_8

object TailRecursion {
  //tail recursive functions are highly optimized in scala
  //Compiler detects tail recursion and replaces it with a jump back to the beginning of the function
  //Tail-recursive function doesn't build a new stack frame for each call but executes in a single frame
  def bang(x: Int): Int =
    if(x == 0) throw new Exception("BANG!")
    else bang(x-1)

  //this is not tail recusie and will create a new stack frame for each call
  def boom(x: Int): Int =
    if(x==0) throw new Exception("BOOM!")
    else boom(x-1) + 1

  //Tail recursion is limited to methods where the call is directly last operation, without going through a function value
}
