package bobrockets{
  package navigation{
    package launch{
      class Booster1
    }
    class MissionControl{
      val booster1 = new launch.Booster1
      val booster2 = new bobrockets.launch.Booster2
      //every top-level package is treated as a member of package "_root_"
      val booster3 = new _root_.chapter_13.launch.Booster3 //uses class from launch.scala
    }
  }

  package launch{
    class Booster2
  }
}