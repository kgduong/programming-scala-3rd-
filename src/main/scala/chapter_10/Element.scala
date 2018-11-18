package chapter_10
import Element.elem

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = contents(0).length

  def above(that: Element): Element ={
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(this1.contents ++ that1.contents)
  }

//  def beside(that: Element): Element = {
//    val contents = new Array[String](this.contents.length)
//    for(i <- this.contents.indices)
//      contents(i) = this.contents(i) + that.contents(i)
//    elem(contents)
//  }

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for(
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }
  override def toString: String = contents mkString "\n"
  //empty parentheses are appropriate if the method performs I/O, reassignable variables, reads vars other than receivers fields or uses mutable objects
  def heighten(h: Int): Element =
    if(h <= height) this
    else{
      val top = elem(' ', width, (h - height)/2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
}

//We create a companion Element object as a factory for the rest of our elements
object Element {
  //we can now place our subclasses as private members inside our elemnt class
  private class ArrayElement(val contents: Array[String]) extends Element
  private class LineElement(str: String) extends Element {
    val contents = Array(str)
    override def width: Int = str.length
    override def height = 1
  }
  private class UniformElement(ch: Char,
                               override val width: Int,
                               override val height: Int) extends Element{
    private val line = ch.toString * width
    def contents: Array[String] = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)
  def elem(line: String): Element =
    new LineElement(line)
  def elem(chr: Char, width: Int, height: Int): Element ={
    if(width < 0 || height < 0) throw new IllegalArgumentException("Negative width or height passed")
    new UniformElement(chr, width, height)
  }

}
