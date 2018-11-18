package chapter_13

class Rocket {
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20
}


object Rocket{
  private def fuel = 10
  def chooseStrategy(rocket: Rocket) = {
    if(rocket.canGoHomeAgain) goHome()
    else pickAStar()
  }
  def goHome()= {}
  def pickAStar() = {}
}

//a class shares all access rights with it's companion object and vice versa
//companion objects do not have subclasses