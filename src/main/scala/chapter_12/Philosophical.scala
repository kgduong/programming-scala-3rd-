package chapter_12

//Traits are like classes in which they can mutate state and have concrete definitions
//have 2 exceptions however:
//1. a trait cannot have any "class" parameters
//2. super calls in traits are dynamically bounded, meaning super() implementation is determined anew each time super is called
trait Philosophical {
  def philosophize(): Unit = {
    println("I consume memory, therefore I am!")
  }
}
