package org.example

object Polymorphic {

  case class MyPair[A, B] (a : A, b : B ){

  }

  def listOfDuplicates[D](element : D, length : Int) : List[D] = {
    if(length < 1) Nil
    else{
      element :: listOfDuplicates(element, length - 1)
    }
  }

  def main(args: Array[String]): Unit = {

     println(listOfDuplicates(3, 4))
    println(MyPair[Int, Int](1, 2))

  }

}
