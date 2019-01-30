package chapter_26

//An extractor for strings that consists of the same substring twice in a row
object Twice {
  def apply(s: String): String = s + s

  def unapply (arg: String): Option[String] ={
    val length = arg.length / 2
    val half = arg.substring(0, length)
    if(half == arg.substring(length)) Some(half) else None
  }
}

object UpperCase{
  def unapply(s: String): Boolean = s.toUpperCase == s
  //do not need to define apply as there's nothing to construct
}

