package part1adv

import scala.annotation.tailrec

object Recap extends App {
  val aCondition: Boolean = false
  val aConditionedVal = if (aCondition) 42 else 34
  // instructions vs expressions
  // - instructions executed in sequence
  // - expressions built on top of expressions
  // compiler infers types
  val aCodeBlock = {
    if (aCondition) 23
    else 324
  }
  // Unit -> type of expressions that only return side effects
  //      -> println(), void = Unit in java

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail; @tailrec
  @tailrec def factorial(n: Int, accumulator: Int): Int =
    if (n <= 0) accumulator
    else factorial(n - 1, n * accumulator)

  // OOP
  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal) : Unit
  }

  class Croc extends Animal with Carnivore {
    override def eat(a: Animal) : Unit = println("crunch")
  }
  val aCroc = new Croc
  aCroc eat aDog // equivalent to aCroc.eat(aDog)



  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal) = println("roar")
  }


  // generics
  abstract class MyList[+A] // variance/variance problems
  // singletons and companions
  object MyList

  // case classes
  case class Person(name: String, age: Int)

  // exceptions and try/catch/final
  val throwsException = throw new RuntimeException
  val aPointlessFailure = try {
  } catch {
    case e: Exception => "caught an exception"
  } finally {
    println("some logs")
  }

  // functional programming
  val incrementer = (X: Int) => X + 1
  List(1,2,3).map(incrementer) // HOF
  // map, flatmap, filter

  // for-comprehension
  val pairs = for {
    num <- List(1,2,3)
    chars <- List('a','b','c')
  } yield  num + "-" + chars


  // scala collections: Lists, Seqs, Arrays, Vectors, Maps, Tuples
  val aMap = Map(
    "christian" -> 704,
    "nicole" -> 980
  )

  // pattern matching
  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }

  val bob = Person("bob", 22)
  val greeting = bob match {
    case Person(n, _) => s"hi my name is $n"
  }
}
