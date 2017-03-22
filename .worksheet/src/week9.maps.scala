package week9

import scala.collection.Map.WithDefault

object maps {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(126); 
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10);System.out.println("""romanNumerals  : scala.collection.immutable.Map[String,Int] = """ + $show(romanNumerals ));$skip(79); 
  
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern");System.out.println("""capitalOfCountry  : scala.collection.immutable.Map[String,String] = """ + $show(capitalOfCountry ));$skip(104); val res$0 = 
  
 // capitalOfCountry("andorra")	// throws an NoSuchElementException
  capitalOfCountry get "andorra";System.out.println("""res0: Option[String] = """ + $show(res$0));$skip(28); val res$1 = 
  capitalOfCountry get "US";System.out.println("""res1: Option[String] = """ + $show(res$1));$skip(151); 
  
  def showCapital(country: String) = capitalOfCountry.get(country) match {
  	case Some(capital)	=> capital
  	case None						=> "missing data"
  };System.out.println("""showCapital: (country: String)String""");$skip(28); val res$2 = 
  
  showCapital("Andorra");System.out.println("""res2: String = """ + $show(res$2));$skip(20); val res$3 = 
  showCapital("US");System.out.println("""res3: String = """ + $show(res$3));$skip(60); 
 
 	val fruit = List("apple", "pear", "orange", "pinapple");System.out.println("""fruit  : List[String] = """ + $show(fruit ));$skip(39); val res$4 = 
 	fruit sortWith (_.length < _.length);System.out.println("""res4: List[String] = """ + $show(res$4));$skip(15); val res$5 = 
 	fruit.sorted;System.out.println("""res5: List[String] = """ + $show(res$5));$skip(25); val res$6 = 
 	fruit groupBy (_.head);System.out.println("""res6: scala.collection.immutable.Map[Char,List[String]] = """ + $show(res$6));$skip(95); 
 	
 	val capitalOfCountryWithDefaultValue = Map("US" -> "Washington", "Switzerland" -> "Bern");System.out.println("""capitalOfCountryWithDefaultValue  : scala.collection.immutable.Map[String,String] = """ + $show(capitalOfCountryWithDefaultValue ));$skip(65); val res$7 = 
 	capitalOfCountryWithDefaultValue.withDefaultValue("Not found");System.out.println("""res7: scala.collection.immutable.Map[String,String] = """ + $show(res$7));$skip(52); val res$8 = 
 	
 	capitalOfCountryWithDefaultValue get "andorra";System.out.println("""res8: Option[String] = """ + $show(res$8));$skip(44); val res$9 = 
  capitalOfCountryWithDefaultValue get "US";System.out.println("""res9: Option[String] = """ + $show(res$9))}
}
