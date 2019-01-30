package chapter_26

object Domain {
  //The injection method (optional)
  def apply(s: String*): String = s.reverse.mkString(".")

  //The extraction method (mandatory)
  //unapplySeq constructs a sequence for the reverse of string
  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}

//we can use the Domain extractor to get variable parts in other extractors
object ExpandedEmail {
  def unapplySeq(email: String): Option[(String, Seq[String])] = {
    val parts = email split "@"
    if(parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else
      None
  }
  //Can match on string such as val ExpandedEmail(name, topdom, subdoms @ _*) = "kduong@uci.edu"
}