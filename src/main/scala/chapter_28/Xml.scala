package chapter_28

class Xml {
  //Xml is formed through text and tags
  //  - <tags> are alphanumeric labels
  //  - starting tags can have attributes to them,

  //Scala allows XML literals where expressions are
  val xmlExample = <a>
      Here is some XML.
      Here is a tag: <atag/>
    </a>


  //Elem => class representing an XML element
  //Text => node holding just text
  //NodeSeq => holds a sequence of nodes

  //Use curly braces to apply scala code that returns Nodes or values
  val xmlWithScalaCode =
    <a>{if (1 < 2) <old>One is less than two</old>
    else xml.NodeSeq.Empty}
    </a>


  /*
    3 important operations of XML nodes in Scala:
      1. text
      2. sub-element
      3. attributes
   */
  val exampleTag = <a>Sounds <tag/> good</a>
  val text = exampleTag.text
//  val subElementByTagName = xmlWithScalaCode \\~"old"
  val attributes = xmlWithScalaCode.attributes

  /*
    Can deserialize Xml objects by calling attributes and the class constructors
   */

  //When converting Xml to binary, it's best to use a library that tracks your encoding
  //Saving our node object as an xml file
  scala.xml.XML.save("random.xml", exampleTag)
  //Loading is simple
  val exampleTagLoaded = scala.xml.XML.loadFile("random.xml")


  //Example of pattern matching with Xml
  def XmlPatternMatch(node: scala.xml.Node): String = node match {
    case <a>{contents}</a> => "It's an a: " + contents //single match <a> tag
    case <b>{contents}</b> => "It's a b: " + contents
    case <c>{contents @ _*}</c> => "Matches all contents in c: " + contents
    case _ => "It's something else"
  }
}
