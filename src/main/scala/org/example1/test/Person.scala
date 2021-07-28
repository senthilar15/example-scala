package org.example1.test

class Person (name : String, age : Int) {

  private var _age: Int = age;
  def say : String =  s"${Person.sayHi()}, My name is $name, and i am ${_age} years old."

  def sayName : String = name
  def sayAge : Int = _age
  def sayAge_= (newAge : Int) : Unit = {
    if ( newAge > 18)
      {
        this._age = newAge
      }
  }

}

object Person {
  def apply(name: String, age: Int) = new Person(name, age)
  def sayHi() :  String = s"Hi"
}
