package chapter_9

object HigherOrderFunction {
  //Higher-Order Functions are functions that take functions as parameters and can invoke them

  //exists is a higher order function on a List collection
  def containsNegs(nums: List[Int]): Boolean = nums.exists(_ < 0)
}
