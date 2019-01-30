package chapter_26

object Email {
  //The injection method (optional)
  //  - Email("kduong", "uci.edu") would construct "kduong@uci.edu"
  //  - injection method as it takes arguments and yields an element of a given set
  def apply(user: String, domain: String) = user + "@" + domain

  //The extraction method mandatory
  //  - returns constructs of email address, or None if the string passed is not an email
  //  - specific function that is called when using pattern matches
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if(parts.length == 2)
      Some(parts(0), parts(1))
    else
      None
  }
  //Note: the injection method should be the dual to the extraction method
  //  => Good design principle to maintain   i
}
