package org.example

object Loops {

  def forLoops() = {
    val res = for ( i <- 5 to 10 ) yield i * 10
    println(res)
    val l = List("Apple", "Orange","Banana")

   val f =  for {
      f <- l
      if(f.startsWith("A"))
    } yield f.toUpperCase()
    println(f)
  }

  def main(args: Array[String]): Unit = {
    forLoops()
  }

}
