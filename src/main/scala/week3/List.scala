package week3

// Change "T" to "+T" so that when List shows up as method results like in Test beneath,
// the relationship is covariant
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  // Use lower bounds to make method prepend variance-correct
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}


class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  /** Definitions of head and tail:
    * Actually we have already implemented them using the parameter names in the parameter list.
    * So the "val head: T" is actually a legal implementation for the method "def head: T" in the base class List[T].
    * And the same holds for the tail value that we have in the parameter list.
    */

  /** So what that shows is that in Scala, val definitions, so field definitions in classes,
    * are really special cases of methods. And they can override methods, and they can implement
    * abstract methods and traits.
    * The difference between val and the def concerns only the initialization.
    * A val is evaluated directly when the object is first initialized. Whereas a def is evaluated each time
    * it is referenced. A lazy val is evaluated once when it is referenced.
    */
}

// objects can't have type parameters
object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object Test {
  val x: List[String] = Nil
}

object Lecture3_3 {
  // Like classes, functions can have type parameters
  def singleton[T](elem: T) = new Cons[T](elem, Nil)

  singleton[Int](1)
  singleton[Boolean](true)
}

/** Polymorphism means that a function type comes "in many forms".
  * In programming, it means:
  * the function can be applied to arguments of many types, or
  * the type can have instances of many types.
  */

/** We have seen two principal forms of polymorphism:
  * subtyping: instances of a subclass can be passed to a base class
  * generics: instances of a function or a class are created by type parameterization
  */
