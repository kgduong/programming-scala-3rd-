import CheckSumAccumulator.calculate

object FallWinterSpringSummer extends App{
  //by extending App trait, this object does not need a "main" method
  //access command line array through "args" variable
  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}
