package chapter_17

object InitializingCollections {
  //Most common way to create and initialize a collection is to pass
  //initial elements to a factory method of your chosen collection
  val alphabet = Set('A', 'B', 'C')

  //Sometimes you must specify the Type stored by the collection
  val AnySet = collection.mutable.Set[Any](1)
  AnySet += ("Kobe")
  AnySet += List(1,2)

  //Sometimes you want to move items from one collection to another
  val colors = "blue"::"yellow"::"red"::"green"::Nil
  import scala.collection.immutable.TreeSet
  val sortedColorsTreeSet = TreeSet[String]() ++ colors

  //converting any collection to a List or an Array is simple however
  //Note that the collections below preserve the order of TreeSet
  val colorsList = sortedColorsTreeSet.toList
  val colorsArray = sortedColorsTreeSet.toArray


  //Converting from immutable to mutable and back
  //Use an empty collection and the ++ method
  val colorImmutableSet = Set.empty ++ sortedColorsTreeSet
  val colorMutableSet = scala.collection.mutable.Set.empty[String] ++ sortedColorsTreeSet

}
