package org.example

object Pizza {


}

sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onions extends Topping

sealed trait CrustSize
case object SmallCrustSize extends CrustSize
case object MediumCrustSize extends CrustSize
case object LargeCrustSize extends CrustSize

sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType extends CrustType
case object ThickCrustType extends CrustType

class Pizza (
              var crustSize: CrustSize = MediumCrustSize,
              var crustType: CrustType = RegularCrustType
            ) {

  // ArrayBuffer is a mutable sequence (list)
  import scala.collection.mutable._
  val toppings: ArrayBuffer[Topping] = scala.collection.mutable.ArrayBuffer[Topping]()

  def addTopping(t: Topping): Unit = toppings += t
  def removeTopping(t: Topping): Unit = toppings -= t
  def removeAllToppings(): Unit = toppings.clear()

}