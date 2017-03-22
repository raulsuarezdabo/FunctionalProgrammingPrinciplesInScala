package week9

import scala.io.Source

object x {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(161); 
  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt");System.out.println("""in  : scala.io.BufferedSource = """ + $show(in ));$skip(189); 
  
  /* create a list and filter all words where *all* their characters are not letters (like dashes) */
  val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter));System.out.println("""words  : List[String] = """ + $show(words ));$skip(180); 
  
  /* define the map of numbers to letters */
  val nmem = Map( '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ");System.out.println("""nmem  : scala.collection.immutable.Map[Char,String] = """ + $show(nmem ));$skip(156); 
  
  /* invert the map the get a map of letters to digits */
  val charCode: Map[Char, Char] =
  	for ((digit, str) <- nmem; ltr <- str) yield ltr -> digit;System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(139); 
  /* define a function that returns the numbers of a given word */
  def wordCode(word: String): String =
  	word.toUpperCase map charCode;System.out.println("""wordCode: (word: String)String""");$skip(23); val res$0 = 
  	
  wordCode("JAVA");System.out.println("""res0: String = """ + $show(res$0));$skip(160); 
  
  /* group all words of our long list with the same number */
  val wordsForNum: Map[String, Seq[String]] =
  	words groupBy wordCode withDefaultValue Seq();System.out.println("""wordsForNum  : Map[String,Seq[String]] = """ + $show(wordsForNum ));$skip(259); 
  	
  def encode(number: String): Set[List[String]] =
  	if (number.isEmpty) Set(List())
  	else {
  		for {
  			split <- 1 to number.length
  			word <- wordsForNum(number take split)
  			rest <- encode(number drop split)
  		} yield word::rest
  	}.toSet;System.out.println("""encode: (number: String)Set[List[String]]""");$skip(28); val res$1 = 
  	
  	encode("7225247386");System.out.println("""res1: Set[List[String]] = """ + $show(res$1));$skip(84); 
	def translate(number: String): Set[String] =
		encode(number) map (_ mkString " ");System.out.println("""translate: (number: String)Set[String]""");$skip(25); val res$2 = 
	translate("7225247386");System.out.println("""res2: Set[String] = """ + $show(res$2))}
}
