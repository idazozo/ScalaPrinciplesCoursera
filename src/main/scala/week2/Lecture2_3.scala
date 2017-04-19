package week2

import math.abs

/**
  * Created by admin on 4/4/2017.
  */
object Lecture2_3 {
  def main(args: Array[String]): Unit = {
    println(sqrt(2))
    println(sqrt2(2))
  }

  def isCloseEnough(x: Double, y: Double): Boolean = {
    val tolerance = 0.000001
    if (x == 0 || y == 0) abs(x - y) < tolerance
    else (abs(x - y) / y) / x < tolerance
  }

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    val next = f(firstGuess)
    if (isCloseEnough(firstGuess, next)) next
    else fixedPoint(f)(next)
  }

  def sqrt(x: Double): Double = fixedPoint(y => (x / y + y) / 2)(1)

  // Funcitons are essential abstractions.
  // These abstractions can be combined with higher-order functions to create new abstractions.
  // Always look for opportunities to abstract and reuse when they are appropriate.

  def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

  def sqrt2(x: Double) = fixedPoint(averageDamp(y => x / y))(1)
}
