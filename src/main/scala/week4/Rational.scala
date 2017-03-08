package week4
/**
  * Created by Raul on 06/03/2017.
  */
class Rational(x: Int, y: Int) {
  // cheeks conditions if not throws an IlegalArgumentException
  require(y != 0, "denominator must be nonzero")

  // second constructor
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def number = x
  def denom = y

  def < (that: Rational) = number * that.denom < that.number * denom

  def max(that: Rational) = if (this < that) that else this

  def + (that: Rational) =
    new Rational(
      number * that.denom + that.number * denom,
      denom * that.denom
    )

  def unary_- : Rational = new Rational(-number, denom)

  def - (that: Rational) = this + -that

  override def toString: String = {
    val g = gcd(number, denom)
    number/g + "/" + denom/g
  }
}
