package oracleacademy.tsukanov.practice.practice6.part1;

public class NamePrinterInter implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new NamePrinterInter());
        thread.start();
    }
}
