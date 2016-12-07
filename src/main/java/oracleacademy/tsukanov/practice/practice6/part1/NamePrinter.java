package oracleacademy.tsukanov.practice.practice6.part1;

public class NamePrinter extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(getName());
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        NamePrinter namePrinter = new NamePrinter();
        namePrinter.start();
    }
}
