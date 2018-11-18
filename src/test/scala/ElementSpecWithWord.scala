import org.scalatest.WordSpec
import org.scalatest.prop.PropertyChecks
import org.scalatest.MustMatchers._
import chapter_10.Element.elem

//WordSpec is ScalaTest style class
//PropertyCheck provides several forAll methods that allows you to mix tests
//

class ElementSpecWithWord extends WordSpec with PropertyChecks {
  "elem result" must {
    "have passed with" in {
      forAll{(w: Int) =>
        //whenever clause indicates that whenever left hand is true, right hand side must also be true
        whenever(w > 0){
          elem('x', w, 3).width must equal(w)
        }
      }
    }
  }
}
