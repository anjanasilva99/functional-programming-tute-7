object Q1 extends App {
  val r1 = new Rational(1,5)
  val ans = r1.neg

  println(r1)
  println(ans)

}

class Rational(n:Int, d:Int){

  require(d>0, "Denominator must be positive")
  private def gcd(a:Int, b:Int):Int = if(b==0) a else gcd(b, a%b)
  private val g = gcd(math.abs(n), d)

  def this(n:Int) = this(n, 1)
  def numer = n / g
  def denom = d / g

  override def toString  = numer + "/" + denom

  def neg = new Rational(-this.numer, this.denom)

}
