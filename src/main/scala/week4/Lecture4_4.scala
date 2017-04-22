package week4

object Lecture4_4 {
  /** Variance Checks:
    * covariant type parameters can only appear in method results
    * contravariant type parameters can only appear in method parameters
    * invariant type parameters can appear anywhere
    */
  trait Function1[-T, +U] {
    def play(x: T): U
  }

  def example(a: Int, b: Boolean): String = {
    a.toString
  }

  trait Fydio[-T, +U] {
    def a(x: T): U
    def b(x: String): Int
    def c(x: T, y: T): Int
  }
}
