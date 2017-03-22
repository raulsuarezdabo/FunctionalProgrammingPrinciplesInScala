package week9

object polynomials {
  class Poly (val terms: Map[Int, Double]) {
  // Auxiliary constructor
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	def + (other: Poly) = new Poly(terms ++ other.terms map adjust)
  	def adjust(term: (Int, Double)): (Int, Double) = {
  		val (exp, coeff) = term
  		terms get exp match {
  			case Some(coeff1) => exp -> (coeff + coeff1)
  			case None					=> exp -> coeff
  		}
  	}
  	
  	override def toString =
  		(for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
  }
  
  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
                                                  //> p1  : week9.polynomials.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : week9.polynomials.Poly = 7.0x^3 + 3.0x^0
  
 	p1 + p2                                   //> res0: week9.polynomials.Poly = 12.4x^5 + 11.0x^3 + 4.0x^1 + 3.0x^0
 	
 	p1.terms(7)                               //> java.util.NoSuchElementException: key not found: 7
                                                  //| 	at scala.collection.MapLike$class.default(MapLike.scala:228)
                                                  //| 	at scala.collection.AbstractMap.default(Map.scala:59)
                                                  //| 	at scala.collection.MapLike$class.apply(MapLike.scala:141)
                                                  //| 	at scala.collection.AbstractMap.apply(Map.scala:59)
                                                  //| 	at week9.polynomials$$anonfun$main$1.apply$mcV$sp(week9.polynomials.scal
                                                  //| a:25)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week9.polynomials$.main(week9.polynomials.scala:18)
                                                  //| 	at week9.polynomials.main(week9.polynomials.scala)
}