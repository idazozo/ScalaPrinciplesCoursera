package week4

import week3._

object Lecture4_3 {
  val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
//  val b: Array[IntSet] = a // Type Error! In Scala, arrays are not covariant.
//  b(0) = Empty
  val s: NonEmpty = a(0)
}
