package chapter_20


//To further express precise modeling of classes, use Abstract Types
class Food
abstract class Animal{
  //Abstract type that must be defined by the implementation of the class
  type SuitableFood <: Food // "<: Food" means that SuitableFood has an upperbound of Food
  //Any concrete instantiation of SuitableFood is a subclass of food
  def eat(food: SuitableFood)
}

//With the new implementation, you can create strictewr anaimals
class Grass extends Food
class Cow extends Animal{
  override type SuitableFood = Grass
  override def eat(food: Grass) = {}
}


class DogFood extends Food
class Dog extends Animal{
  type SuitableFood = DogFood
  override def eat(food: DogFood) = {} //Only can be passed DogFood
}

//structural subtyping where you get a subtyping relationship because two types have compatible members
class Pasture{
  var animals: List[Animal{type SuitableFood = Grass}] = Nil //Elements of animals will be animals with suitable food as Grass, aka cows
}


//path-dependent type names an outer object,
class Outer{
  class Inner
}