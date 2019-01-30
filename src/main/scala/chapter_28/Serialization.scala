package chapter_28

//Serialization => conversion from internal data structures to XML
class Serialization {
  val name: String = "Kyle Duong"
  val role: String = "Data Engineer"
  val year: Int = 1995

  def toXML =
    <serialization>
      <name>{name}</name>
      <role>{role}</role>
      <year>{year}</year>
    </serialization>
}
