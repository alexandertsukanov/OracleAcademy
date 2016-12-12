package oracleacademy.tsukanov.homework.task7.lock;

public class Bank {

    private final String name;

    Bank(String name) {
        this.name = name;
    }

   public String getName() {
        return this.name;
    }

    public synchronized void makeTransaction(Bank bank) {
        System.out.println(this.name + " is making transaction to " + bank.getName());
        bank.makeTransaction(this);
    }

}
