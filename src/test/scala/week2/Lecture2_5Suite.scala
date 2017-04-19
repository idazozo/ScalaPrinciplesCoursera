package week2

import org.scalatest.FunSuite
import week2.Lecture2_5.Rational

/**
  * Created by admin on 13/4/2017.
  */
class Lecture2_5Suite extends FunSuite{
  test("18/12 is simplified into 3/2") {
    val a = new Rational(18, 12)
    assert(a.toString === "3/2")
  }
}
