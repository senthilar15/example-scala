package org.example1.test

import java.io.IOException
import java.util.Optional
import scala.util.{Failure, Success, Try}

object Exception {

  def main(args: Array[String]): Unit = {

  /* val t = callClosable(new Closable) (a => a.read("Read"))
   t  match {
     case Success(value) => println(value)
     case Failure(e) => println(e)
   }*/

    val t = Try(tryDemo("null"))
    t match {
      case Success(res) => println("Success")
      case Failure(ex) => println("Failure")

    }
  }


  def tryDemo(a: String): Try[Unit] ={

    a.toUpperCase()
    tryUnit(false) /*match {
      case Success(value) => Success(value)
      case Failure(ex) => Failure(ex)
    }*/
  }

  def tryUnit(a: Boolean): Try[Unit] = {
    if(a) Success(Unit) else Failure(new NullPointerException)
  }

  def callClosable[A <: AutoCloseable, B](closeable: A)(fun: (A) => B): Try[B] = {


    Try(fun(closeable)).transform(
      result ⇒ {
        closeable.close()
        Success(result)
      },
      funT ⇒ {
        Try(closeable.close()).transform(
          _ ⇒ Failure(funT),
          closeT ⇒ {
            funT.addSuppressed(closeT)
            Failure(funT)
          }
        )
      }
    )
  }
}

class Closable extends AutoCloseable {


  def read(a: String) : String ={
    if(a == "Read") "Read" else throw new NullPointerException
  }

  override def close(): Unit = {
    throw new IOException
  }

}
