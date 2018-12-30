package chapter_21

import java.awt.event.{ActionEvent, ActionListener}

class Implicit {
  //Implicit definitions are those that the compiler is allowed to insert a program in order to fix type errors
  //Implicit conversions allow working with 2 bodies of software without being developed with each other in mind
  //Implicit conversion help reduce the number of explicit conversions that are needed from one type to another

  //Example here is an implicit conversion from functions to action listeners
  implicit def function2ActionListener(f: ActionEvent => Unit) =
    new ActionListener {
      override def actionPerformed (e: ActionEvent) = f(e)
    }
  //Implicit conversions will be inserted automatically by compiler where needed
  //If the compiler sees a type error for a specific type, it will check for implicit conversions before giving up


  /*
    Implicit conversions are governed by the following general rules:
      1. Only definitions marked implicit are available

      2. Scope Rule => inserted implicit conversion must be in scope as a single identifier
          - Most libraries include a Preamble object that helps with the useful conversions
          - The exception to the above is if, the implicit definitions are in companion objects or target type of conversions

      3. Only one implicit is inserted
          - The compiler does not recur on an implicit conversion chain, it only applies one implicit conversion
      4. Explicit-first rule:
          - The compiler will not apply implicit conversions to code that already works

      5. Naming an implicit conversion
          - Naming your implicit conversions allow for the use of selective imports

      6. Where implicits are tried
          - Conversion to an expected type
          - conversion of the receiver of a selection
          - implicit parameters

   */
}
