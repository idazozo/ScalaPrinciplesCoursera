package week4

import java.util.NoSuchElementException

class Lecture4_1 {

  /** Peano Numbers
    */
  abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat = new Succ(this)
    def + (that: Nat): Nat
    def - (that: Nat): Nat
  }

  object Zero extends Nat {
    def isZero = true
    override def predecessor = throw NoSuchElementException
    def + (that: Nat): Nat = that
    def - (that: Nat):Nat = {
      if (!that.isZero) throw NoSuchElementException
      else Zero
    }
  }

  class Succ(n: Nat) extends Nat {
    def isZero = false
    def predecessor: Nat = n
    def + (that: Nat): Nat = predecessor + that.successor
//    def + (that: Nat): Nat = n + new Succ(that)

    def - (that: Nat): Any = {
      if (!predecessor.isZero && !that.isZero) {
        predecessor - that.predecessor
      } else if (that.isZero) this
//      if (that.isZero) this else n - that.predecessor
    }
  }
}
