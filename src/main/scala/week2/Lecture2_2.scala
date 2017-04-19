package week2

/**
  * Created by admin on 31/3/2017.
  */

// Currying

object Lecture2_2 {
  def main(args: Array[String]): Unit = {
    println(sumFactorials(3, 4))
    println(sum(fact)(3, 4))
    println(product(x => x * x)(3, 4))
    println(product2(x => x * x)(3, 4))
    println(fact2(5))
  }

  // sum is now a function that returns another function
  // The returned function sumF applies the given function parameter f and sums the results
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }

  def product(f: Int => Int): (Int, Int) => Int = {
    def prod(a: Int, b: Int): Int =
      if (a > b) 1
      else f(a) * prod(a + 1, b)
    prod
  }

  def sumInts = sum(x => x)
  def sumCubes = sum(x => x * x * x)
  def sumFactorials = sum(fact)

  def fact(x: Int): Int = if (x == 0) 1 else  x * fact(x - 1)

  def fact2(a: Int) = product(x => x)(1, a)

  // -------------------
  // Map Reduce exercise
  // -------------------

  def sum_product(c: Int, g: (Int, Int) => Int)(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) c
    else g(f(a), sum_product(c, g)(f)(a + 1, b))
  }

  def product2(f: Int => Int)(a: Int, b: Int) = sum_product(1, (x, y) => x * y)(f)(a, b)
  def product3 = sum_product(1, (x, y) => x * y)_
}