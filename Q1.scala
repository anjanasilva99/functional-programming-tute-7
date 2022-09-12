object Q1 extends App{

    val alph="ABCDEFGHIJKLMNOPQRSTUVWXYZ"


    val encryption = (shift:Int,c:Char)=>
      if((alph.indexOf(c.toUpper))== -1) c
      else alph((alph.indexOf(c.toUpper)+shift)% alph.size)

    val decryption =(shift:Int,c:Char)=> {
      if((alph.indexOf(c.toUpper))== -1) c
      else if((alph.indexOf(c.toUpper)-shift)<0) alph((alph.indexOf(c.toUpper)-shift+alph.size)% alph.size)
      else alph((alph.indexOf(c.toUpper)-shift)% alph.size)
    }

    val Cipher = (func:(Int,Char)=>Char,s:String,shift:Int)=> s.map(func(shift,_))

    println("Enter String:")
    val msg=scala.io.StdIn.readLine();

    println("Enter 0-to encrypt message");
    println("Enter 1-to decrypt message");
    val a=scala.io.StdIn.readInt()

    println("Enter Shift Number:")
    var shiftnumber=scala.io.StdIn.readInt()
    if(a==0){

      println("Encrypt message :"+Cipher(encryption, msg, shiftnumber))
    }
    else{
      println("Decrypt message :"+Cipher(decryption, msg,shiftnumber))
    }

}



