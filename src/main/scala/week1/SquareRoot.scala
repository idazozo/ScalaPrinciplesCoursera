package week1

object SquareRoot {
  def main(args: Array[String]): Unit = {
    println(sqrt(4))
    println(sqrt(1e20))
    println(sqrt(1e-6))
    println(sqrt(1e60))
  }

  def abs(x: Double): Double = {
    if (x >= 0) x else -x
  }

  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    }
    def isGoodEnough(guess: Double): Boolean = {
      abs(guess * guess - x) / x < 0.001
    }
    def improve(guess: Double): Double = {
      (guess + x / guess) / 2
    }

    sqrtIter(1.0)
  }
}
