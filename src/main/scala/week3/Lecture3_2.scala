package week3

import week2.Lecture2_5.Rational
/** Some entities are automatically imported in any Scala program
  * These are:
  * All members of package scala (wwww.scala-lang.org/api/current)
  * All members of package java.lang
  * All members of the singleton object scala.Predef
  */

object Lecture3_2 {
  new Rational(1, 2)

  def error(msg: String) = throw new Error(msg)
  def main(args: Array[String]): Unit = {
    println(error("test"))
  }

  // Null is subtype of every class that inherits from Object;
  // It is incompatible of subtypes of AnyVal (those primitive types)
  val x = null // x: Null
  val y: String = null // y: String
//  val z: Int = null // error: Type mismatch
}
