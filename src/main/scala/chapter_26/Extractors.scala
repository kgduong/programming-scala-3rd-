package chapter_26

/*
  Extractors:
    => define new patterns for preexisting types, where the pattern doesn't need to follow internal representation of type
    => Has an unapply method to match a value and take it apart
    => Will cast a value to a specific type first, if it's cast-able then it'll cast else the pattern fails immediately
    => You can use sequence patterns, i.e. List(), List(x, y, _*), in collections because of Extractors in their case objects

 */
class Extractors {


}

/*
  Extractors vs Case Classes:
    - Extractors:
      => are representation independent
      => represent a layer of indirection between a data representation and way it's viewed by clients
      => Allows you to changes an implementation type in components without affecting clients of these components
      => best for unknown clients, in preference of representation independence

    Case classes:
      => much easier to define and require less code
      => lead to more efficient pattern matches over extractors
      => compiler will check for exhaustiveness in base classes of case classes
      => best used for closed clients, due to conciseness, speed, and static checking
 */

//Can mix extractors with regular expression searches in a for expression