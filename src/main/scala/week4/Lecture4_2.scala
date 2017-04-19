package week4

class Lecture4_2 {
  // Syntax sugar for new Function1[Int, Int] {
  new ((Int) => Int) {
    def apply(x: Int): Int = x * x
  }

  /** Note that a method that is defined starting with "def"such as
    * def f(x: Int): Boolean = ... is not itself a function value.
    * But if f is used in a place where a function type is expected,
    * it is converted automatically to the function value:
    * (x: Int) => f(x), or expanded(which is called eta-expansion):
    * new Function1[Int, Boolean] {
    *   apply(x: Int): Boolean = f(x)
    */

  import week3._

  object List {
    // List(1, 2) = List.apply(1, 2)
    def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
    def apply[T]() = new Nil
  }
}
