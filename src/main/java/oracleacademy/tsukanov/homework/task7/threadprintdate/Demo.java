package oracleacademy.tsukanov.homework.task7.threadprintdate;

import java.util.Scanner;

public class Demo{

    public static void main(String[] args) {

        Thread a = new Thread(new MyThreadImplRun(), "Thread Runnable");
        MyThread b = new MyThread("Extended Thread");
        b.start();
        a.start();
        Scanner scanner = new Scanner(System.in);
        String s;
        s = scanner.nextLine();
        a.interrupt();
        b.interrupt();
    }
}
