object Q3 extends App {
  var acc1= new Account("20000001v",10000100,1000.00);
  var acc2= new Account("20000002v",10000101,25000.00);
  var acc3= new Account("20000003v",10000102,500.00);

  var bank:List[Account] = List(acc1,acc2,acc3)

  var display = () => bank.foreach(x=>println("["+x.acnumber+": "+x.balance+"]"))


  println("Before trnasfer")
  display()

  //transfer 500 to acc3 from acc1
  acc1.transfer(acc3,500)

  println("\nAfter trnasfer")
  display()
}

class Account(id:String, n:Int, b:Double){

  var nic:String = id
  var acnumber:Int = n
  var balance:Double = b

  override def toString = "["+nic+":"+acnumber +":"+balance+"]"

  def withdraw(x:Double) = if(x<=balance)this.balance = this.balance - x else println("Insufficent balance!")

  def deposit(a:Double) = this.balance = this. balance + a

  def transfer(account:Account, amount:Double) = {
    this.withdraw(amount)
    account.deposit(amount)
  }


}
