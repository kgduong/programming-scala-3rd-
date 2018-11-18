package chapter_11

object TinyTypes {
    //avoid writing mangled like so
//  def title(text: String, anchor: String, style:String): String =
//    s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

  //Code above is mangled and confuses compiler due to use of same types
  //best to write tiny type for each domain concept
  class Anchor(val value:  String) extends AnyVal
  class Style(val value: String) extends AnyVal
  class Text(val value: String) extends AnyVal
  class Html(val value: String) extends AnyVal

  //can rewrite title with a less trivial type signature
  def title(text: Text, anchor: Anchor, style: Style):Html =
    new Html(s"<a id='${anchor.value}'><h1 class='${style.value}'>${text.value}</h1></a>")
}
