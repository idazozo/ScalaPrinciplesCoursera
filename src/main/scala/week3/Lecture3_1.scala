package week3

object Lecture3_1 {
  def main(args: Array[String]) {
    val t1 = new NonEmpty(3, Empty, Empty)
    val t2 = t1 incl 4
    println(t2)
  }
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

// Use keyword "object" instead of "class" creates a singleton object
// No other Empty instances can be (or need to be) created
// Singleton objects are values, so Empty evaluates to itself
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }
  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }
  override def toString: String = "{" + left + elem + right + "}"
  def union(other: IntSet): IntSet = {
    ((left union right) union other) incl elem
  }
}

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}