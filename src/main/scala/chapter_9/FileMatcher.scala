package chapter_9

import java.io.File

object FileMatcher {
  private def filesHere = new java.io.File(".").listFiles

  def filesEnding(query: String): Array[File] =
    for(file <- filesHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String): Array[File] =
    for(file <- filesHere; if file.getName.contains(query))
      yield file

  //both filesEnding and filesContaining follow a similar pattern, it's possible to refactor with higherorderfunctions
  //add a match parameter to check filename against specific query
  def filesMatching(query: String, matcher: (String,String) => Boolean): Array[File] = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }

  //we can simplify the above queries using files Matching
  def filesEndingOverride(query: String): Array[File] = filesMatching(query, _.endsWith(_))
  def filesContainingOverride(query: String): Array[File] = filesMatching(query, _.contains(_))


}
