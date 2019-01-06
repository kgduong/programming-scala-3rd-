package chapter_24

trait Sequence {
  //Seq trait represents sequences, which is an iterable that has a length and elements at fixed indexed positions starting at 0
  //Have the following operations:
  /*
    - Indexing and Length: apply(), isDefinedAt, lengthCompare()
    - Index Search: indexOf(), lastIndexOfSlice(), ...
    - Sorting: sorted, sortWith, sortBy
    - Addition/Update: creating new Sequences by replacing elements or adding to sequence
   */
}

//Each Seq has two sub traits: LinearSeq and IndexedSeq
//Both provide the same operations but has different performance characteristics

//LinearSequence provides efficient head and tail operations, example is List and Stream
trait LinearSequence extends Sequence
//IndexedSequence provides efficient indexing, length and mutable operations, example is Array and ArrayBuffer
trait IndexedSequence extends Sequence

//***Vector class provides a compromise between indexed and linear sequence, providing good foundation for mixed access
//***Buffers are mutable sequences that provide efficient insertion,removal, and additions of elements





