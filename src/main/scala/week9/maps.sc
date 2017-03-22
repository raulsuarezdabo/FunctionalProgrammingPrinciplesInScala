package week9

import scala.collection.Map.WithDefault

object maps {
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V 
                                                  //| -> 5, X -> 10)
  
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  
 // capitalOfCountry("andorra")	// throws an NoSuchElementException
  capitalOfCountry get "andorra"                  //> res0: Option[String] = None
  capitalOfCountry get "US"                       //> res1: Option[String] = Some(Washington)
  
  def showCapital(country: String) = capitalOfCountry.get(country) match {
  	case Some(capital)	=> capital
  	case None						=> "missing data"
  }                                               //> showCapital: (country: String)String
  
  showCapital("Andorra")                          //> res2: String = missing data
  showCapital("US")                               //> res3: String = Washington
 
 	val fruit = List("apple", "pear", "orange", "pinapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pinapple)
 	fruit sortWith (_.length < _.length)      //> res4: List[String] = List(pear, apple, orange, pinapple)
 	fruit.sorted                              //> res5: List[String] = List(apple, orange, pear, pinapple)
 	fruit groupBy (_.head)                    //> res6: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pinapple), a -> List(apple), o -> List(orange))
 	
 	val capitalOfCountryWithDefaultValue = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountryWithDefaultValue  : scala.collection.immutable.Map[String,St
                                                  //| ring] = Map(US -> Washington, Switzerland -> Bern)
 	capitalOfCountryWithDefaultValue.withDefaultValue("Not found")
                                                  //> res7: scala.collection.immutable.Map[String,String] = Map(US -> Washington, 
                                                  //| Switzerland -> Bern)
 	
 	capitalOfCountryWithDefaultValue get "andorra"
                                                  //> res8: Option[String] = None
  capitalOfCountryWithDefaultValue get "US"       //> res9: Option[String] = Some(Washington)
}