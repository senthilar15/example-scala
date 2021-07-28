package org.example1.test

object Sample {


  def apply(x : Int, y : Int): Point =
  {
    new Point()
  }

  class Point(var x :Int = 1, var y : Int = 10)
  {

    def move(dx : Int, dy : Int) : Unit = {
      x = x + dx
      y = y + dy
    }

    def moveOn(dx : Int = 10, dy : Int = 20, dz : Int = 30): Unit =
    {
      println(s"$dx $dy $dz");
    }




    override def toString: String = s"($x, $y)"
  }

  val v = {
    val v = 1+1
    println("coming here")
    v
  }

  val addOne = (x : Int) => x+1

  def currying(a : Int)(b : Int) : Unit = {
    println(a * b)
    //java.lang.Object
  }

  def main(args: Array[String]) : Unit = {
    println("Hello "+addOne(v))
    currying(1)(2)
    val l : List[Any] = List("Hello", 123, 123.566, true, () => "Random String")
    val f = () => "a function"

    val f1 = new Function0[String] {
      override def apply(): String = "none"
    }
    println(f1.apply())
    val p = new Point(y = 2);
    for(l1 <- l){
      if(l1.isInstanceOf[Function0[String]]) {

        val ff = l1.asInstanceOf[Function0[String]];
        println(ff.apply());

      }
      p.move(2, 2);
      p.moveOn(dx = 100, 20,dz = 40);
      println(p)
    }
  }
}
