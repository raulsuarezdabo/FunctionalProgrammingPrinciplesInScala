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
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(623); 
  
  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2));System.out.println("""p1  : week9.polynomials.Poly = """ + $show(p1 ));$skip(40); 
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0);System.out.println("""p2  : week9.polynomials.Poly = """ + $show(p2 ));$skip(13); val res$0 = 
  
 	p1 + p2;System.out.println("""res0: week9.polynomials.Poly = """ + $show(res$0));$skip(17); val res$1 = 
 	
 	p1.terms(7);System.out.println("""res1: Double = """ + $show(res$1))}
}
