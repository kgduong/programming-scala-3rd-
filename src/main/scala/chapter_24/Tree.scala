package chapter_24

//Example of a Tree class that inherits from Traversable
//The Tree has Integers for leaves
sealed abstract class Tree extends Traversable[Int]{
  //Overrides foreach trait by traversing tree from left to right in O(N)
  def foreach[U](f: Int => U) = this match {
    case Node(elem) => f(elem)
    case Branch(l,r) => l foreach f; r foreach f
  }
}

case class Branch(left: Tree, right: Tree) extends Tree
case class Node(elem: Int) extends Tree

//We can create a Tree that extends Iterable
//However, an iterator for a binary tree is inefficient since the traversal would be N logN
// Due to every iterator generated must also traverse the rest of the tree to get it's next partner
