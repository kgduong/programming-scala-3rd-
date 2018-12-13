package chapter_17

object Tuples {
  //Tuples combine a fixed number of items together as a bundle
  val randomTuple = (1, "hello", Console)

  //Helps save tedious work of creating data-heavy classes
  //Common use is to return multiple values from a method
  def longestWord(words: Array[String]) = {
    var word = words(0)
    var idx = 0
    words.foreach(w =>
      if(w.length > word.length) {
        word = w
        idx = words.indexOf(word)
      })
    (word, idx)
  }

  //Tuples are great when combining data with no meaning beyond their grouping
  //When the data does have a meaning or you want methods for that data, it's best to create a class

}
