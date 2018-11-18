package chapter_13.navigation{
  class Navigator
  package tests{
    //in package chapter_13.navigation.tests
    class NavigatorSuite

  }
  class Ship{
    //no need to say chapter_13.navigation.Navigator
    val nav = new Navigator
  }
  package fleets{
    //can have multiple packages within the same file
    class Fleet{
      def addShip() = new Ship
    }
  }
}
