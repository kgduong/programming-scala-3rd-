package chapter_21

object ImplicitParameters {

  class PreferredPrompt(val preference: String)
  class PreferredDrink(val preference: String)

  //The last parameter is marked implicit, meaning you can supply it implicitly
  object Greeter{
//    def greet(name: String)(implicit prompt: PreferredPrompt) = {
//      println("Welcome, " + name + ". The system is ready.")
//      println(prompt.preference)
//    }

    def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) = {
      println("Welcome, " + name + ". The system is ready.")
      println("But while you work, ")
      println("why noy enjoy a cup of " + drink.preference + "?")
      println(prompt.preference)
    }
  }

  //To supply Greeter.greet parameter implicitly, first define a variable of the expected type
  object KylesPreference{
    //Implicit values that are supplied wherever implicit parameters are missing and in scope
    implicit val prompt = new PreferredPrompt("Yes, master>")
    implicit val drink = new PreferredDrink("Hennessy")
  }


  //Implicit parameters are most often used to provide information about a type mentioned explicitly in an earlier parameter list
  //Below is a non general method to obtain the max of a list, we can generalize it through implicits later
  def maxListOrdering[T](elements: List[T])(ordering: Ordering[T]): T = {
    elements match {
      case Nil => throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListOrdering(rest)(ordering)
        if (ordering.gt(x, maxRest)) x
        else maxRest
    }
  }

  //Implicit parameter ordering provides more information regarding type T, in this case how to order this type
  //Because T is defined in "elements", the compiler will know which ordering to supply
  def maxListImpParm[T](elements: List[T])(implicit ordering: Ordering[T]): T = elements match{
    case List() => throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest: T = maxListImpParm(rest)(ordering)
      if(ordering.gt(x, maxRest)) x
      else maxRest
  }
  //If T is any common Scala type, an implicit ordering will be passed by the Scala compiler


  //*** A style rule for implicit parameters***
  /*
      - best to use a custom named type for implicit parameters
      - named types indicate better understanding of code
      - Use at least one role-determining name within the type of an implicit parameter
   */


  //*** Context Bounds ***
  /*
      - When using implicit, you often encounter a pattern where a type parameter requires more context
      - In such situations, use `context bounds` aka descriptions about a type parameter
      - [T : Ordering] introduces a type parameter T along with implicit parameter of type Ordering[T]
      -
   */
  //We can rewrite maxListImpParm with the new context bound
  def maxList[T : Ordering](elements: List[T]): T = elements match { //T : Ordering states that there is some Ordering for type T
    case Nil => throw new IllegalArgumentException("Empty list!")
    case List(x) => x
    case x :: tail =>
      val maxTail  = maxList(tail)
      //implicitly[Ordering[T]] looks for implicit definition of type Ordering[T]
      //This way we don't actually have to state the Ordering type in our code
      if(implicitly[Ordering[T]].gt(x, maxTail)) x
      else maxTail
  }
}
