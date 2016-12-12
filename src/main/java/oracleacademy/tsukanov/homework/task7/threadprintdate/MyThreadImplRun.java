package oracleacademy.tsukanov.homework.task7.threadprintdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreadImplRun implements Runnable {

    Thread t;

    @Override
    public void run() {
        t = Thread.currentThread();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        do {
          System.out.println(t.getName() + ": " + dateFormat.format(new Date()));
            try {
                t.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(t.getName() + " interrupted.");
                t.interrupt();
            }
        } while (!t.isInterrupted());
    }
}
