package org.example

object Functions {

  def urlBuilder(ssl : Boolean = true, domainName : String ): (String, String) => String = {
  {
    val schema = if(ssl) "https://" else "http://"
    (endPoint, query) => s"$schema$domainName/$endPoint?$query"
  }
  }

  def partialApplication() : List[Int] = {

    val list = List(1,2,3,4)
    val func = list.foldLeft(List[Int]()) _
    func((xs, x) => xs :+ x+x)
  }

  def factorial(f : Int = 1) : Int = {
    def fact(ff : Int, acc : Int = 1) : Int = {
      if(ff == 1) acc
      else fact(ff -1, ff *acc)
    }
    fact(f)
  }

  def add(x : Int)(y : Int)  = x + y
  def multiply(x : Int)(y : Int) = x * y

  def main(args: Array[String]): Unit = {
    val getUrl = urlBuilder(domainName = "google.com")
    println(getUrl("query","q=scala"))
    println(partialApplication())
    println(factorial(6))
    val addAndMultiply = add(10) _ andThen multiply(20)

    println(s"value : ${addAndMultiply(10)}")
  }
}
