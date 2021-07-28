package org.example1.test

object TestOop {

  def main(args: Array[String]): Unit = {
       val car = new Car("ABC")
  }


  class Vehicle(name : String) {

     println(s"$name")

  }

  class Car(name : String) extends Vehicle(name) {

  }
}

trait Speaker {
  def speak(): String   //abstract
}

trait TailWagger {
  def startTail(): Unit = println("tail is wagging")
  def stopTail(): Unit = println("tail is stopped")
}

trait Runner {
  def startRunning(): Unit = println("I'm running")
  def stopRunning(): Unit = println("Stopped running")
}

class Dog1(name: String) extends Speaker with TailWagger with Runner {
  def speak(): String = "Woof!"
}