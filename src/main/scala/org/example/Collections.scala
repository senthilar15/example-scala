package org.example

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Collections {

  def mapDemo() : Unit = {
    val m = collection.mutable.Map (
      0 -> "zero",
      1 -> "One",
      2 -> "Two"
    )

    val m1 = collection.mutable.Map (
      "One" -> "zero",
      "mode" -> "One",
      "Three" -> "Two",
      "format" -> "P"
    )



    m1.filter(e => {(e._1.toUpperCase != "MODE" && e._1.toUpperCase != "FORMAT")}).foreach {
      case (str, str1) => println(s"${str} : ${str1}  ")
    }

    m1.filterKeys(e => {(e.toUpperCase != "MODE" && e.toUpperCase != "FORMAT")}).foreach {
      case (str, str1) => println(s"${str} : ${str1}  ")
    }

    val m2 = m1 --= Set("mode", "format")
    m2.foreach {
      case (str, str1) => println(s"${str} : ${str1}  ")
    }
    println(m.get(3) match {
      case Some(value) => value
      case None => "Nothing"
    })

   for((key, value) <- m) {
    //  println(s"$key, $value")
   }
    import scala.collection.immutable.Map

    val im = scala.collection.immutable.Map(0 -> "zero",
      1 -> "One",
      2 -> "Two")


    val im1 = im + (5 -> "Five")
    for((key, value) <- im1) {
      println(s"after mutate $key = $value")
    }
    for((key, value) <- im) {
      println(s"before mutate $key = $value")
    }


   println(m(2))
    m += (4 -> "Four")
    im.foreach {
      case (key, value) => println(s"$key, $value")
    }

  }

  def setDemo(): Unit = {

    val set = collection.mutable.Set(1, 2 , 3)
    set ++= List(2,4,5)
    set.foreach(println)
    val ab = collection.mutable.ArrayBuffer(10, 20 , 30)

  }
  def main(args: Array[String]): Unit = {
    println(List(5,1,3,11,7).dropWhile (_ < 6))
    mapDemo()
    setDemo()

    //   val v =  Collections {
    //      1
    //      2
    //    }
  }

}

