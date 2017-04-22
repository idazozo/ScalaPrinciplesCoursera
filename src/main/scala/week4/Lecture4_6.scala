package week4

import week4.Lecture4_5._

object Lecture4_6 {
  /** Decomposition. Attempts seen previously:
    * Classification and access methods: quadratic explosion
    * Type tests and casts: unsafe, low-level
    * Object-oriented decomposition: does not always work, need to touch all classes to add a new method
    */

  /** Solution 2: Functional Decomposition with Pattern Matching
    * A case class definitions preceded by the modifier "case". It also implicitly defines
    * companion objects with "apply" methods.
    *
    * Pattern matching is a generalization of switch from C/Java to class hierarchies.
    * It's expressed in Scala using the keyword match.
    * match is followed by a sequence of "cases, patter_name => expression"
    *
    * Patterns are constructed from:
    * constructors, e.g. Number, Sum,
    * variables, e.g. n, e1, e2,
    * wildcard patterns _,
    * constants, e.g. 1, true.
    *
    * Beware:
    * Variables always begin with a lowercase letter.
    * The same variable name can only appear once in a pattern. So, Sum(x, x) is not legal.
    * Names of constants begin with a capital letter, with the exception of the reserved words null, true, false.
    */

  // Example:
  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
  }

  // Or:
//  trait Expr {
//    def eval: Int = this match {
//      case Number(n) => n
//      case Sum(e1, e2) => e1.eval + e2.eval
//    }
//  }

  /** Expression problem:
    * Both of these designs are perfectly fine and choosing between them is sometimes a matter of style, but
    * nevertheless there are some criteria that are important. One criteria could be, are you more often
    * creating new sub-classes of expression or are you more often creating new methods? It's a criterion
    * that looks at the future extensibility and the possible extension parts of your system. If what you do
    * is mostly creating new subclasses, then actually the OO decomposition solution has the upper hand.
    * The reason is that it's very easy and a very local change to just create a new subclass with an eval
    * method, whereas in the functional solution, you'd have to go back and change the code inside the eval
    * method and add a new case to it.
    *
    * On the other hand, if what you do will be create lots of new methods, but the class hierarchy itself
    * will be kept relatively stable. Then pattern matching is actually advantageous. Because, again, each
    * new method in the pattern matching solution is just a local change, whether you put it in the base
    * class, or maybe even outside the class hierarchy. Whereas a new method such as show in the OO decomposition
    * would require a new incrementation is each sub class. So there would be more parts that you'd have to touch.
    */

//  def show(e: Expr): String = e match {
//    case Number(n) => "" + n
//    case Sum(e1, e2) => eval(e1) + " + " + eval(e2)
//  }

  // Or:
  def show(e: Expr): String = e match {
    case Prod(s1: Sum, s2: Sum) => "(" + show(s1) + ") * (" + show(s2) + ")"
    case Prod(s: Sum, expr) => "(" + show(s) + ") * " + show(expr)
    // "case Prod(s@Sum(e1, e2),..." means s which matches Sum(e1, e2)
    case Prod(expr, s: Sum) => show(expr) + " * (" + show(s) + ")"
    case Number(n) => n.toString
    case Var(n) => n
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => show(e1) + " * " + show(e2)
  }

  def main(args: Array[String]): Unit = {
    println( show(Prod(Sum(Number(1), Number(44)), Var("x"))) )
    println( show(Prod(Var("x"), Sum(Number(1), Number(44)))) )
    println( show(Prod(Sum(Number(1), Number(44)), Sum(Var("x"), Var("y")))) )
    println( show(Sum(Prod(Var("x"), Number(8)), Var("y"))))
    println( show(Sum(Var("y"), Prod(Var("x"), Number(8)))))
  }
}
