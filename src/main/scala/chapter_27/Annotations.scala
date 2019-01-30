/*
  Annotations:
    - meta-programming tools that sprinkle directives to the tool throughout their source code
    - minimum orthogonal support in core language
    - annotations can be applied on functions, expressions, declarations, or definitions
 */


//Scala's standard annotations:


@deprecated class QuickAndDirty {}
//  - deprecated code triggers a warning when used in client code
//  - Scala compiler will emit deprecation warnings whenever this code is accessed
//@deprecated("use NewShinyMethod() instead") def OldAndBusted()
////  - will return warning string when called
//
//
//
//@volatile class MutableClass{}
////  - informs compiler that variable will be used in multiple threads, to reads and writes variables that are slower
//
//@SerialVersionUID(1234) class MySerializableClass
//// - Attaches a serial number of current version of class, to help index when serializing and de-serializing code
//@transient class NotSerializableClass
////  - annotation for classes that should not be serialized
//
//
//@scala.reflect.BeanProperty def MyField = 1
////automatically generates get and set methods for a specific field, named:
////  - getMyField
////  - setMyField
//
//
//@unchecked def patternMatch{}
////tells compiler not to worry if pattern match does not handle all cases