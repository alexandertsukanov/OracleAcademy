package oracleacademy.tsukanov.homework.task7.threadprintdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    public MyThread(String name) {
        this.setName(name);
    }

    public void run() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        do {
            System.out.println(this.getName() + ": " + dateFormat.format(new Date()));
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " interrupted.");
                this.interrupt();
            }
        } while (!this.isInterrupted());
    }
}
