object Q4 extends App{
  var acc1= new Account("20000001v",100000100,100000.00);
  var acc2= new Account("20000002v",100000101,250000.00);
  var acc3= new Account("20000003v",100000102,-5000.40);
  var acc4= new Account("20000004v",100000100,10080.50);
  var acc5= new Account("20000005v",10000101,250400.00);
  var acc6= new Account("20000006v",100000102,74500.75);
  var acc7= new Account("20000007v",100000100,-10060.00);
  var acc8= new Account("20000008v",100000101,250800.40);

  var bank:List[Account] = List(acc1,acc2,acc3,acc4,acc5,acc6,acc7,acc8)

  println("Acount with negative balance : ");
  val negativeBalance = (b:List[Account]) => b.filter(x => x.balance < 0)
  var negativeBalance_list = negativeBalance(bank)
  negativeBalance_list.foreach(x=>println("["+ x.acnumber+": "+x.balance+"]"))

  val sum = (b:List[Account]) => b.reduce((x,y)=>new Account("null",1111111111,x.balance+y.balance))
  var sumOfBalance = sum(bank)
  println("\n" + "Sum of all accounts balances : "+ sumOfBalance.balance)

  println("\nFinal Account balances with interest : ")
  val interest = (b:List[Account]) => b.map(x=>new Account(x.nic,x.acnumber,(if(x.balance>=0) x.balance*1.05d else x.balance*1.10d)))
  var interest_list = interest(bank)
  interest_list.foreach(x=>println("["+x.acnumber+": "+x.balance+"]"))
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
