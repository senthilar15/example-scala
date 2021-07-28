package org.example1.test

sealed class Furniture
case class Couch(cushion : Boolean = true) extends Furniture
case class Chair() extends Furniture
