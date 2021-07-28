package org.example

import org.example1.test._

import java.time.{Clock, Instant, ZoneId}
import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder, FormatStyle}
import java.util.Locale;

object TestClazz {


  def showNotification(notification : Notification) : String = {

    notification match {
      case s: SMS => s"SMS  ${s.message} from ${s.number}"
      case EMAIL(sender, _, body) => s"Email $body from sender $sender"
      case other => "others"
    }

  }

  def demoFurniture(furniture: Any) : Unit = {

    furniture match {

      case cc: CozyCouch=> println(s"Cozy Couch : ${cc.cushion}")
      case Couch(_) => println("Couch")
      case Chair() => println("Chair")
      case (leather, legs) => println(s"leathers : $leather and legs : $legs")
    }
  }


  def testExtractorObject(): Unit = {

    val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
    val s : Option[String] = CustomerID.unapply(customer1ID)

    s match {
      case Some(name) => println(name)
      case _ => println("Nothing")
    }

    val customer2ID = CustomerID("Nico")
    val CustomerID(name) = customer2ID
    println(name)  // prints Nico

    val CustomerID(name2) = "--asdfasdfasdf"
//    val CustomerID(name3) = "-asdfasdfasdf"
    customer1ID match {
      case CustomerID(name) => println(name)  // prints Sukyoung
      case _ => println("Could not extract a CustomerID")
    }
  }

  def testSingleton() = {
    println(Circle(19.0).equals(Circle(10.0)))
  }

  def testPatternMatching() : Unit = {
    println(showNotification(EMAIL(sender = "abc@z.com", "bcd@z.com", "Body")))
    println(showNotification(SMS("SMS","12345")))
    demoFurniture(new CozyCouch());
    demoFurniture((true, 4));
  }

  def testGetterSetters() : Unit = {
    val p = Person("abc", 17)
    println(p.sayName)
    println(p.sayAge)
    println(p.say)
    p.sayAge = 19
    println(p.say)
  }

  def testCaseClasses() : Unit = {
    val message1 = Message("abc@.com", "bcd@z.com","Hi. how are you!")
    val message2 = message1.copy();
    println(message1 == message2)
  }

  def testGenerics(): Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop)  // prints 2
    println(stack.pop)  // prints 1

    var dog : List[Dog] = List(new Dog)
    var ani : List[Animal] = dog
    ani = new Cat :: ani
    var l : List[Animal] = Nil
    l = new Cat :: l
    l = acceptAnimal(dog)

    l.foreach( a => println(a.asInstanceOf[Dog]))
  }

  def acceptAnimal(list : List[Animal]) : List[Animal] = {

    var v = list
    v = new Dog :: list
    v = new Cat :: list
    v
  }

  def testNull(): AnyRef = {
    //type WebRequest = HttpRequest => HttpResponse
    null
  }


  def testBean(): Unit = {
    val customer = new Customer("ABC", 19)
    customer.setAge(20)
    println(customer.getAge)
    println(customer.getName)
  }

  def testType(): Unit = {
    val b = 1
    if(b.isInstanceOf[Int]) println("True") else println("False")

  }

  def findOddOrEven(number : Int) : String = number match {
    case n if n/2 == 0 => "Even"
    case _ => "Odd"
  }

  def findNameByMatch(customer: Customer) : String = customer match {
    case n if n.getName == "ABC" => n.getName
    case _ => "Invalid Name"
  }

  def testCompanion(): Unit = {



  }

  def getParams(array : Array[String]) : (Map[String, String], Map[String, Map[String, String]] ) = {

   val (optionsToReplace, placeHolderParams ) =  array.partition(_.indexOf(":#:") > -1)
    println("TEst")
    val placeHolders =  placeHolderParams.map(e => e.split("="))
      .map(e => e(0).toUpperCase -> e(1)).toMap


    var options = optionsToReplace.map(e => e.split("="))
      .map(e => e(0).toUpperCase -> e(1).split(";")
        .map(_.split(":#:"))
        .map(e => e(0) -> e(1)).toMap)
      .toMap
    (placeHolders, options)
  }

  def test(a : String): Unit =
  {
    a
    println(a)
  }

  def testArray(array : Array[String]): Map[String, String] = {
    array map { e => e.split("=") } map { e => e(0) -> e(1)} toMap
  }

  def getQueryParams(queryParams: String) : Map[String, String] = {
    println(queryParams)
    val m = queryParams split(";") map {e => e.split(":")} map {e => e(0) -> e(1)} toMap;
      m
  }

  def replacePlaceHolders(placeHolders: String, queryParams: Map[String, String] ) : String  = {
    queryParams.foldLeft(placeHolders)((query, keyValue) => query.replace("${"+keyValue._1+"}", keyValue._2))
  }

  def main(args: Array[String] ): Unit = {
    testGetterSetters()
    testCaseClasses()
    testPatternMatching()
    testSingleton()
    testExtractorObject()
   // testGenerics()
    testNull()
    testBean()
    testType()
    println(findOddOrEven(10))
    println(findNameByMatch(new Customer("B", 20)))
    testCompanion()
    val query =
      """CREATE TABLE ${Table_Name}
        | USING PARQUET
        | LOCATION '/${tmp}/${Year}/${Month}/${Date}'
        | As
        | SELECT SiteId, ParitionId from ${format}.`/${tmp}/${spark}/*.parquet`
        |""".stripMargin


    var array = Array[String]("query_params=query_path:#:/BI_site_1/site/;tmp:#:tmp;format:#:parquet;spark:#:spark;Year:#:21;Month:#:07;Date:#:18")
    array = array :+ "application_params=workflow_name:#:sample;app_name:#:SampleApp"
    array= array :+ "read_options=inferSchema:#:true;header:#:true"
    array = array :+  "write_options=format:#:json;mode:#:override"
    array = array :+  s"sql_query=${query}"
    array = array :+  "App_name=TestApp"
    array = array :+  "wf_name=Tes_wf"
    array = array :+  "output_path=/${tmp}/${spark}"

    val (placeHolder, paramsToReplace) = getParams(array)
    val sql = replacePlaceHolders(placeHolder("SQL_QUERY"), paramsToReplace("QUERY_PARAMS"))
    val outputPath = replacePlaceHolders(placeHolder("OUTPUT_PATH"), paramsToReplace("QUERY_PARAMS"))
    println(sql)
    println(outputPath)
    //val map = testArray(array)
    //val queryParams = getQueryParams(map("query_params"))
    //val sql = processQuery(map, queryParams)
    //println(sql)

    Option("Something").flatMap(s => Option(s))
    print("Hello aaaa")

    //yyyy-MM-dd'T'HH:mm:ss


    println(DateTimeFormatter.ofPattern("yyyyMMdd").withZone(ZoneId.systemDefault()).format(Instant.now()))
   // println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault()).format(Instant.now()))

  }

}
