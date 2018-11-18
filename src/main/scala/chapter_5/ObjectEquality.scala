package chapter_5

object ObjectEquality {
  //Compare objects using == and !==
  //operations apply to all objects not just type:
  val booleanCheck = List(1,2,3) == List(1,2,3)

  //you can also compare different types of object
  println(1 == 1.0)
  //can compare against nulls without having null exception
  //Equality check compares the left side first before checking the left

  //How scala's  == differs from Java's
  //Java's == checks for reference equality in reference types.
  //Scala can do this through eq operator
  //Only applies to objects that directly map to Java objects, i.e. Strings
  val booleanReference = "Hello" ne "hello"
}
