package week2

/**
  * Created by admin on 7/4/2017.
  */
object Lecture2_5 {
  def main(args: Array[String]) {
    val x = new Rational(1, 3)
    println(x.numor)
    println(x.denom)

    val y = new Rational(5, 7)
    println(x + y)

    val z = new Rational(3, 2)
    println((x + y).mul(z))
    println(x - y - z)
//    println(x.less(y))
    // Infix notation. While only works for methods with single parameter.
    // So if replace "less" by "<" in the method definition, it works the same.
    println(x < y)
//    println(x less y)
    println(x.max(y))

    val a = new Rational(18, 12)
    println(a)

    val s = "I am a string"
    val l = List("no")
    println("Test for method exists of List and method contains of java.lang.String. Result: " + l.exists(s.contains))
  }

  class Rational(x: Int, y: Int) {
    require(y != 0, "denominator must be nonzero")

    // The second constructor
    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private val g = gcd(x, y)
    def numor = x / g
    def denom = y / g

    def < (that: Rational) = numor * that.denom < that.numor * denom
//    def less(that: Rational) = numor * that.denom < that.numor * denom

    def max(that: Rational) = if (this < that) that else this
//    def max(that: Rational) = if (this.less(that)) that else this

    def + (that: Rational) =
      new Rational(
        numor * that.denom + denom * that.numor,
        denom * that.denom)

    // Beware the difference between the unary minus (negative) and the operator minus
    def unary_- : Rational = new Rational(- numor, denom)
//    def neg = new Rational(- numor, denom)

//    def sub(that: Rational) =
//      new Rational(
//        numor * that.denom - denom * that.numor,
//        denom * that.denom)

    // Don't repeat yourself
    def - (that: Rational) = this + -that
//    def - (that: Rational) = this + that.neg
//    def sub(that: Rational) = add(that.neg)

    def mul(that: Rational) =
      new Rational(
        numor * that.numor,
        denom * that.denom)

    override def toString = numor + "/" + denom
  }
}
