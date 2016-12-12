package oracleacademy.tsukanov.homework.task7.lock;

public class Demo {



    public static void main(String[] args) {

       final Bank otpBank = new Bank("OTPBank");
       final Bank privatBank = new Bank("PrivatBank");


       Thread a = new Thread(() -> {
           otpBank.makeTransaction(privatBank);
       });

      Thread b =  new Thread(() -> {
         privatBank.makeTransaction(otpBank);
      });

        a.start();
        b.start();
    }
}
