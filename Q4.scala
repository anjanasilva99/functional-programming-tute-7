object Q4 extends App{
  // Get negative balance list
  val getNegativeBalance = (b: List[bankAccount]) => b.filter(x => x.balance<0)
  // Cal total of all accounts balance
  val calSum = (b: List[bankAccount]) => b.reduce((x,y) => new bankAccount ((x.balance+y.balance),12345678))
  // Cal and add interest to the balance
  val calInterest = (b: List[bankAccount]) => b.map(x => new bankAccount(x.addInterest,x.num))

  val acc1 = new bankAccount(3000,11001001)
  val acc2 = new bankAccount(-1500,11001002)
  val acc3 = new bankAccount(1600,11001003)
  val acc4 = new bankAccount(-3100,11001004)
  val acc5 = new bankAccount(5300,11001005)
  val acc6 = new bankAccount(8200,11001006)

  // Create a bank as a list of accounts
  var bank: List[bankAccount] = List (acc1,acc2,acc3,acc4,acc5,acc6)

  val negativeList = getNegativeBalance(bank)
  val sum = calSum(bank)
  val interest = calInterest(bank)

  println("Acount wich have negative balance : ")
  println("\tAccount Number\t  Balance")
  negativeList.foreach(x => println("\t"+x.num+"\t = "+x.balance))
  println()

  println("Total of all account balances : "+sum.balance)
  println()

  println("Final balances of all accounts after adding interest : ")
  println("\tAccount Number\t  Balance")
  interest.foreach(x => println("\t"+ x.num+"\t= "+x.balance))

}

class bankAccount(depamount: Float, accno: Int){

  var balance = depamount
  var num = accno

  def addInterest ={
    balance match{
      case x if x >0 => this.balance + this.balance*0.05f
      case x if x<0 =>  this.balance + this.balance*0.1f
    }
  }
}

