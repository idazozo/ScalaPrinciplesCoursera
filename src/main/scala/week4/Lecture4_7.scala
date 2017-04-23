package week4

object Lecture4_7 {
  /** Lists
    * There are two important differences between lists and arrays:
    * Lists are immutable -- the elements of a list cannot be changed.
    * List are recursive, while arrays are flat.
    *
    * Like arrays, lists are homogeneous: the elements of a list must all have the same type.
    */
  val fruit: List[String] = List("apples", "oranges", "pears")
  val nums: List[Int] = List(1, 2, 3, 4)
  val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty: List[Nothing] = List()

  /** val nums = 1 :: 2 :: 3 :: 4 :: Nil is equivalent to Nil.::(4).::(3).::(2).::(1)
    * :: above works the same as the "prepend" operation that's introduced before
    */

  /** It is also possible to decompose lists with pattern matching
    * Nil   // The Nil constant
    * p :: ps   // A pattern that matches a list with head matching p and a tail matching ps
    * List(p1, ..., pn)   // same as p1 :: ... :: pn :: Nil
    *
    * Examples:
    * 1 :: 2 :: xs    // Lists of elements that starts with 1 and then 2
    * x :: Nil    // Lists of length 1
    * List(x)   // Same as x :: Nil
    * List()    // The empty list, same as Nil
    * List(2 :: xs)   // A list that contains only a single element that is a list as well, and that list starts with 2
    */

  // Sort a list of numbers in ascending order
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  def main(args: Array[String]): Unit = {
    val l: List[Int] = List(4, 2, 6, 9, 0, 1, 3)
    println(isort(l))
  }
}
