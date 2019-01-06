package chapter_24

class Views {
  //Transformers => methods taking one collection and produces another collection, i.e. map, filter, ++
  //  - strict transformer constructs a new collection with all of its elements
  //  - lazy transformer constructs a proxy for result collection, elements are constructed on demand

  //Example of lazy transformer
  def lazyMap[T, U](coll: Iterable[T], f: T => U) =
    //constructs a new Iterable without stepping through all elements of coll
    new Iterable[U]{
      def iterator = coll.iterator map f //calculates new elements on demand
    }

  //Views is  a special collection that represent a base collection, but implements all transformations lazily
  val v = Vector(1 to 10: _*)
  val mappedV = v map (_ + 1) map (_ * 2)
  //in this example, constructing intermediate result of (_ + 1) is wasteful
  //We can avoid intermediate results by creating a view and calculating instead
  val viewV = (v.view map (_ + 1) map (_ * 2)).force

  val vv = v.view //scala.collection.SeqView[Int, Vector[Int]]
  //first type parameter is the type of collection, second is type of collection when you force the view

  //When applying force() to a view, the collection returned is a Seq
  //  - the transformation operations of view causes specific collection type to be lost



  //Reasons to use Views:
  //  - Performance when you don't need to create intermediate results
  //  - Can selectively update sequence elements of a mutable collection

  def isPalindrome(x: String) = x == x.reverse
  def findPalindrome(s: Seq[String]) = s find isPalindrome()
  //example of findPalindrome(words take 1000000), where words is a large collection of strings
  //  - an intermediate sequence of a million words is always constructed, even if first word is palindrome
  //  - using views, a single lightweight view is constructed instead of a million element sequence
  // findPalindrome(words.view find isPalindrome)

  val arr = (0 to 9) toArray
  //You can create a subwindow by creating a slice of a view of the array
  val subarr = arr.view.slice(3,6) //Creates IndexedSeqView
  def negate(xs: collection.mutable.Seq[Int]) = for(i <- 0 until xs.length) xs(i) = -xs(i)
  negate(subarr)
  //arr will now have it's values in the view slices be negative
  //The code above separated concerns of:
  //  1. what index range to apply a method
  //  2. the actual method to apply


  //Strict vs lazy collections(Views):
  //  - for smaller collection sizes, there's a greater overhead in applying View operations
  //  - View operations can be very confusing if there are side effects in code

  //All collections except Streams and Views are strict

  /*
    In Summary:
      - views are a powerful tool to reconcile concerns of efficiency with concerns of modularity
      - Only apply Views in purely functional code, where transformations do not have side effects
      - Or apply them to mutable collections where modifications are done explicitly
      - DO NOT use mixture of views and transformations with side effects
   */
}
