package chapter_5

object OperatorPrecedence {
  //typical operator precedence as you would get in any other programming language
  //(all other special characters) */%
  //+-
  //:
  //=! <> &
  //  ^
  //  |
  //  (all letters)
  //  (all assignment operators)
  //any method ending in `:` character is invoked on its right operand and passes in the left
  //multiple operators of the same precedence, associative property comes into play
  //  associative property is determined by it's an operators last character
  //i.e. a ::: b ::: c is treated as a ::: (b ::: c)
  //while a * b * c is treated as (a * b) * c, because * operator is left to right
}
