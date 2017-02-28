object rationals {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  x - y - z
  y + y
  x < y
  x max y
  //val strange = new Rational(1,0)
  //strange.add(strange)

  new Rational(2)
}

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