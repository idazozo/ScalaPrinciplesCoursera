"Hello World"

// x is a call by name parameter
// the expression is not evaluated until referenced,
// it is a lazy parameter
def evaluateTheCallByNameExpression(x: => Int): Int = {
  x // now evaluates x
}

// unit, the only value
()

// the composite expression evaluates to 3 and prints a line
{
  println("Print first")
  3
}

evaluateTheCallByNameExpression({
  println("Print first")
  3
})

def and(x: Boolean, y: => Boolean) = {
  if(x) y else false
}


