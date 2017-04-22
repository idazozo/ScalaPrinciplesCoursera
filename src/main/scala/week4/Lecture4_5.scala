package week4

object Lecture4_5 {
  trait Expr {
    // Classification
    def isNumber: Boolean
    def isSum: Boolean
    // Accessor
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr
  }

  class Number(n: Int) extends Expr {
    def isNumber: Boolean = true
    def isSum: Boolean = false
    def numValue: Int = n
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")
  }

  class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = true
    def numValue: Int = throw new Error("Sum.numValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }

  class Prod
  // Will have to add isVar, isProd, name to each class, which leads to
  // quadratic increase of methods

  // If, after all, all we want to do is evaluate expressions, then we could have a
  // direct object oriented solution for that. Instead of making eval a method which
  // exists outside our hierarchy, we just write it as a method of expression itself.
  // We call this object oriented decomposition.

  class Var

  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }
}
