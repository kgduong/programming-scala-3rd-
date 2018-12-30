package chapter_22

class NewListBuffer[T]{
  private var start: List[T] = Nil
  private var last0: ::[T] = _
  private var exported: Boolean = false

  //alter exported to true
  //return the start of the list
  def toList: List[T] = {
    exported = !start.isEmpty
    start
  }

  //In Scala you can either construct lists with "::" or a list buffer
  //  - `::` lends itself well to recursive algorithms in divide and conquer style
  //  - List buffers are used in traditional loop-based style
}

