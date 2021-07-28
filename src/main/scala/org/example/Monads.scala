package org.example

object Monads {

  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3)
    list.flatMap(l => String.valueOf(l))

    Thread.currentThread().getContextClassLoader().getParent().getParent().getParent


  }

}
