package chapter_23

//Given a standard chess-board, place eight queens such that no queen is in check from any other queen
//Easiest to generalize place to N x N squares chess board
object NQueens {
  //A recursive approach to the problem consists of representing a solution as a list of coordinates for each queen
  //Place the partial solution as a stack, where coordinates of the queen in row k come first in list
  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] =
      if(k == 0) List(List())
      else{
        for{
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens
      }
    placeQueens(n)
  }

  //method to verify that all queens in solution is safe from new queen to append to stack
  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall (q => !inCheck(queen, q))

  def inCheck(q1: (Int, Int), q2: (Int, Int)) =
    q1._1 == q2._1 || // same row
    q1._2 == q2._2 || //same column
    (q1._2 - q2._1).abs == (q1._2 - q2._2).abs //same diagonal => the difference between their columns and their columns are the same

}
