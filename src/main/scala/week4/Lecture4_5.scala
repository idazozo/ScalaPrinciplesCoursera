package week4

object Lecture4_5 {
  trait Expr {
    // Classification
    def isNumber: Boolean
    def isSum: Boolean
    def isProd: Boolean
    def isVar: Boolean
    // Accessor
    def name: String
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr
  }

  case class Number(n: Int) extends Expr {
    def isNumber: Boolean = true
    def isSum: Boolean = false
    def isProd: Boolean = false
    def isVar: Boolean = false
    def name: String = throw new Error("Number.name")
    def numValue: Int = n
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")
  }

  case class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = true
    def isProd: Boolean = false
    def isVar: Boolean = false
    def name: String = throw new Error("Sum.name")
    def numValue: Int = throw new Error("Sum.numValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }

  case class Prod(e1: Expr, e2: Expr) extends Expr {
    override def isNumber: Boolean = false
    override def isSum: Boolean = false
    def isProd: Boolean = true
    def isVar: Boolean = false
    def name: String = throw new Error("Prod.name")
    def numValue: Int = throw new Error("Prod.numValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }

  case class Var(n: String) extends Expr {
    override def isNumber: Boolean = false
    override def isSum: Boolean = false
    def isProd: Boolean = true
    def isVar: Boolean = false
    def name: String = n
    def numValue: Int = throw new Error("Var.numValue")
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")
  }

  /** Adding classes Prod and Var will lead to adding isVar, isProd, name to each
    * class, which leads to quadratic increase of methods.
    */

  /** If, after all, all we want to do is evaluate expressions, then we could have a
    * direct object oriented solution for that. Instead of making eval a method which
    * exists outside our hierarchy, we just write it as a method of expression itself.
    * We call this object oriented decomposition. However, it doesn't always work, e.g.
    * method simplify, like a*b + a*c => a*(b+c).
    */

  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }
}
