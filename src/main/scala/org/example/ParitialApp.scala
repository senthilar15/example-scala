package org.example

object ParitialApp {

  def main(args: Array[String]): Unit = {

    val fun = write("T") _
    fun((a,b) => {
      println(a)
      b
    })


  }

  def partial(a: String, b: String) : String = {
    print(a)
    b
  }

  def write(a: String)(op: (String, String) => String) : String = {
    "Test"
  }

}
