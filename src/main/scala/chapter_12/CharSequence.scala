package chapter_12

//Thin vs Rich interface
//rich interface => have many methods, making it easy for the caller and clients can call exactly what they need
//thin interface => have fewer methods, easier for implementer but requires clients to write more code

//implementing a thin interface
trait CharSequence {
  def charAt(index: Int): Char
  def length: Int
  def subSequence(start: Int, end: Int): CharSequence
  def toString: String
}
