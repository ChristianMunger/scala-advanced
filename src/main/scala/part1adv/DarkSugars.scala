package part1adv

import scala.util.Try

object DarkSugars extends App {

  // syntax sugar 1 -> methods with single param
  def singleArgMethod(n: Int): String = s"$n little ducks"

  val description = singleArgMethod {
    123
  }

  val aTry = Try {  // java's try {...}
    throw new RuntimeException
  }

  List(1,2,3).map { x =>
    x + 1
  }

  // syntax sugar 2 - Single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = (x: Int) => x + 1

  // example: Runnables
  val aThread = new Thread(() => println("scala"))

  abstract class anAbstractType {
    def implemented: Int = 23
    def f(a: Int): Unit
  }
  val anAbstractInstance: anAbstractType = (a: Int) => println("hi")


  // syntax sugar 3 - the :: and #:: methods
  val prependedList = 2 :: List(3,4)
  // :: is right associative
  // 1 :: 2 :: List(3,4)
  // List(3,4) :: 2 :: 1

  // syntax sugar 4 - multi word method naming
  class teenBoy(name: String){
    def `and then said` (gossip: String) =
      println(s"$name said $gossip")
  }

  val jim = new teenBoy("jim")
  jim `and then said` "i like scala"

  // syntax sugar 5 - infix types
  class Composite[A,B]
  val composite: Composite[Int, String] = ???
  // OR
  val compositeTwo: Int Composite String = ???

  class -->[A,B]
  val towards: Int --> String = ???

  // syntax sugar 6 - update





}
