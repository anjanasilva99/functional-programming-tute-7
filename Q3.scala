object Q3 extends App {
  val x=new Accounts("1967326400v",26006784,25000.00)
  val y=new Accounts("9904207094V",78906785,10000.00)
  println("Before Transfering:")
  println("NIC NO:"+x.Nic)
  println("ACC No:"+x.accountNumber)
  println("Balance:"+x.balance)
  println()
  println("NIC NO:"+y.Nic)
  println("ACC No:"+y.accountNumber)
  println("Balance:"+y.balance)
  println()
  x.transfer(y,2000.00)
  println("After Transfering:")
  println("NIC NO:"+x.Nic)
  println("ACC No:"+x.accountNumber)
  println("Balance:"+x.balance)
  println()
  println("NIC NO:"+y.Nic)
  println("ACC No:"+y.accountNumber)
  println("Balance:"+y.balance)
}

class Accounts(id:String,n:Int,b:Double){

  val Nic:String=id
  val accountNumber=n
  var balance:Double=b

  def transfer(a:Accounts,c:Double)={
    this.balance=this.balance-c
    a.balance=a.balance+c
  }
}
