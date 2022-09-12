object Q2 extends App{
  val x = new Rational(3,4)
  val y = new Rational(5,8)
  val z = new Rational(2,7)

  val ans = x-y-z
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
  def +(r:Rational) = new Rational(this.numer * r.denom + r.numer * this.denom, this.denom * r.denom)
  def -(r:Rational) = this + r.neg
}
