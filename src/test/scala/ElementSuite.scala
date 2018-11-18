import org.scalatest.FunSuite
import chapter_10.Element.elem

class ElementSuite extends FunSuite {
  //In scalatest, we specify a test as a string between paranthesis and the test itself
  test("elem result should have passed width"){
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}
