package chapter_24

//Sets are Iterables that contain no duplicate elements
trait Sets[Elem] extends Iterable[Elem]{
  //Has the following categories of operations:
  /*
    - Tests: apply(), subsetOf() which indicates whether a set contains a given element
    - Addition/Removals: +, ++, -, --
    - Set Operations: Union, Intersection, and Set difference
   */

  //Mutable sets provide a more efficient += operation which add/removes elements as a side effect
  //Mutable sets uses a hash table to store set's elements

  //Immutable sets use the following implementation varying on size:
  //  - empty set and up to size 4 => singleton object with elements as fields
  //  - beyond Sets of size 4 => immutable sets are stored as hash tries

  //Because of this optimization, if your sets are small try to make them immutable
}

//You can often replace a mutable collection stored in a val with a immutable collection stored in a var
