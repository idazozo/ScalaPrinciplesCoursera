package week1

import scala.annotation.tailrec

object Factorial {
  def main(args: Array[String]): Unit = {
    println(fac2(4))
    println(fac2(9))
  }

  // The last action is not a tail recursive call
  def fac1(n: Int): Int = {
    if (n == 0) 1 else n * fac1(n - 1)
  }

  // Rewrite the function so that it becomes Tail Recursion
  def fac2(n: Int): Int = {
    @tailrec
    def loop(acc: Int, n: Int): Int =
      if(n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  }
}