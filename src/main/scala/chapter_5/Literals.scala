package chapter_5

object Literals {
  //Integer Literals
  //Integer literals for types Int, Long, Short, and Byte come in 2 forms: decimal and hexadecimal
  val hex: Int = 0x5
  val hex2: Int = 0x00FF
  val magic: Int = 0xcafebabe
  //Scala shell will always print integer values in base 10, and unless specified in decimal

  //integer literal ending in "L" or "l" will be a long
  val long = 0xCAFEBABEL
  val tower = 35L
  val of = 31L

  //Integer literals falling within range of Short or Byte with that typing will fall so
  val little: Short = 367
  val littler: Byte = 38



  //Floating point literals
  val big = 1.2345
  //use e or E to express decimal value
  val bigger = 1.2345e1
  val biggerStill = 123E45

  //floating point literal ending in F or f is afloat, else it's a double
  val littleFloat = 1.2345F
  val littleBiggerFloat = 3e5F




  //Character Literals
  //composed of any unicode character between single quotes
  val c = 'c'
  //can identify through unicode code point with '\' prefix
  val A = '\u0041'

  //String literal
  //use """ for raw strings
  val rawString = """Welcome to Ultamix 300 || "HELP" for help """


  //Symbol Literal
  //use `ident to mapp instances of predefined scala class symbol
  val s:Symbol = 'aSymbol
}
