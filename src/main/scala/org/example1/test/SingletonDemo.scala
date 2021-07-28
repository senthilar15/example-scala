package org.example1.test

import org.example1.test.Circle.calculateArea

import scala.util.Random

class Circle(val radius : Double)
{

//  val a : Double = calculateArea
  def area : Double = {
    calculateArea(radius)
  }

  override def equals(obj: Any): Boolean = {
    if(!obj.isInstanceOf[Circle]) false
    val other = obj.asInstanceOf[Circle]
    this.radius == other.radius
  }
}

object Circle
{
  def apply(radius : Double) : Circle = {
    new Circle(radius)
  }
  def calculateArea(radius : Double) : Double = {
    math.Pi * math.pow(radius, radius)
  }
}


object CustomerID {

  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}

