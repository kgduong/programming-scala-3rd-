import org.scalatest.FlatSpec
import org.scalatest.Matchers
import chapter_10.Element.elem

class ElementSpec extends FlatSpec with Matchers {
  //FlatSpec allows you to write specific tests
  //You create a name for a subject, i.e. "UniformElement" and write strings/code specifying behavior
  "A UniformElement" should
    "have a width equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.width should be (2)
  }

  //it represents our subject, aka UniformElement
//  it should "have a height equal to the passed value" in {
//    val ele = elem('x', 2, 3)
//    ele.height should be (3)
//  }
//
//  it should "throw an IAE if passed a negative width" in {
//    an [IllegalArgumentException] should be thrownBy elem('x', -2, -3)
//  }

  //Matchers allows you to write assertions that read more like natural language
}
