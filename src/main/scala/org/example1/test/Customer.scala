package org.example1.test

class Customer(name : String, age : Int) {

  private var _name : String = name
  private var _age : Int = age

  def getName : String = _name
  def setName(name : String) : Unit = {
    if(_name == "ABC")
      {
        _name = "lower_abc"
      }
  }

  def getAge : Int = _age
  def setAge(newAge : Int) : Unit = {
    if(newAge > 18){
      _age += 1
    }
  }

}
