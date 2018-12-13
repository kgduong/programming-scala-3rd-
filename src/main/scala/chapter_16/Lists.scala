package chapter_16

object Lists {
  //Lists are immutable and have a recursive structure
  //List type in Scala is covariant. Meaning for each pair of type S and T, if S subtype T, then List[S] subtype List[T]
  val listNothing: List[Int] = List()
  val nilList: List[Any] = Nil
  val nums = 1::2::3::4::Nil

  //Lists in scala comprise of 3 basic properties
  //1.) head => first element of list
  //2.) tail => list of all elements except first
  //3.) isEmpty => Boolean if empty


  //Running insertion sort on a list
  def insertion(x: Int, xs: List[Int]): List[Int] = {
    if(xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insertion(x, xs.tail)
  }
  def insertionSort(xs: List[Int]): List[Int] = {
    if(xs.isEmpty) Nil
    else insertion(xs.head, insertionSort(xs.tail))
  }

  //Rewriting insertion sort using pattern match
  def isort(xs: List[Int]): List[Int] = xs match{
    case Nil => Nil
    case x::xs1 => insert(x, isort(xs1))
  }
  def insert(x: Int, xs: List[Int]):List[Int] = xs match{
    case Nil => x::Nil
    case y::ys => if(x <= y) x :: xs
                  else y::insert(x,ys)
  }

  //Scala shorthand for concatenation is ":::"
  //We can use pattern match to apply a divide and conquer principle
  def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil => ys
    case x :: xs1 => x::append(xs1, ys)
  }

  //Since scala's list are linked lists, it's computationally more expensive to use length than isEmpty

  //init and last are duals of tail and head
  //last => last element in list
  //init => every element except last
  //Takes O(n) so it's best to use head and tail

  //slower recursive reversal of a list, is quadratic in nature
  def reverseList[T](xs: List[T]): List[T] = xs match{
    case Nil => xs
    case x::xs1 => reverseList(xs1):::List(x)
  }

  //take(n) => return first n elements
  //drop(n) => returns list except for first n ones
  //splitAt(n) => splits list at given index aka: (xs take n, xs drop n)
  //apply(n) => get nth element, equals xs.drop(n).head

  //zip takes two list and create paired tuples, if unmatched length the unmatched elements are dropped


  //implementation of merge sort
  //Is tail recursive and take o(n logn)
  def mergeSort[T](less: (T,T) => Boolean)(xs:List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs,ys) match {
      case(Nil,_) => ys
      case (_, Nil) => xs
      case (x::xs1, y::ys1) =>
        if(less(x,y)) x :: merge(xs1,ys)
        else y :: merge(xs, ys1)
    }
    val n = xs.length/2
    if(n == 0)xs
    else{
      val (lst1, lst2) = xs.splitAt(n)
      merge(mergeSort(less)(lst1), mergeSort(less)(lst2))
    }
  }



  //Using Higher Order Methods on lists
  //mapping for list
  val mixedInts = List(4, 1, 9, 0, 5, 8)
  val addedOne = mixedInts.map(_ + 1)

  val words = "the"::"quick"::"brown"::"fox"::Nil
  val wordsLength = words.map(_.length)
  val reversedString = words.map(_.toList.reverse.mkString)

  //span is a combination of takeWhile and dropWhile
  val (upToZero, afterZero) = mixedInts.span(_ > 0)

  //foldLeft operator short hand is /:
  //foldRight operator short hand is \:
  //We can use foldLeft to reverse a list in linear time
  def reverseLeft[T](xs: List[T]) =
    xs.foldLeft(List[T]())((ys,y) => y::ys)

  //Use sortWith to sort a list based on a specific predicate



  //List has a globally accessible companion object scala.List which contains factory methods
  //An example would be range
  val oneUpToSeven = List.range(1,7)
  //fill(n)(m) => create's n elements of value m
  val fiveAs = List.fill(5)('A')
  //tabulate(n)(f: => Y) => creates n elements and applies f(n)
  val squares = List.tabulate(5)(n => n * n)


  //Processing multiple lists
  //when you have zipped lists, a map function can be applied to both list
  //any element that is out of bound of a zip is discarded
  val zippedMultiple = (List(10,20), List(3,4,5)).zipped.map(_*_)
}