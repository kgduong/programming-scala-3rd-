package chapter_12

//Traits in scala are also stackable, meaning you can alter behaviour for each

//creating an abstract class IntQueue which
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

//our trait extends IntQueue meaning it can only mixed into a class that extends IntQueue
trait Doubling extends IntQueue{
  //notice that our put method is declared abstract with a call to super??
  //Because traits are dynamically bound, the "super" call will work if the trait is mixed in after a concrete definition is giving to put
  //abstract override signals that you're using stackable modifications
  abstract override def put(x: Int) = super.put(x * 2)
}

trait Incrementing extends IntQueue{
  abstract override def put(x: Int) = super.put(x + 1)
}

trait Filtering extends IntQueue{
  abstract override def put(x: Int) = if(x >= 0) super.put(x)
}

//Stackable traits means that it overrides based on the order of inheritance
//i.e. BasicIntQueue with Incremental with Filtering
//has a different application compared to "BasicIntQueue with Filtering with Incremental"
//Scala calls traits furthest to the right first


//Mixing in Scala differs from multiple inheritance in multiple ways
// 1. super can be determined right away in multiple inheritance, traits meanwhile
//    uses linearization to determine stacking of modifications
/*
    linearization => scala takes a class and all of it's inherited class/traits and stacks them in linear order
 */
