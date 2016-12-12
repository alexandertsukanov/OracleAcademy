package oracleacademy.tsukanov.homework.task7.comparingcounters;

public class CounterComparator extends Thread {

   Counter counter;

    public CounterComparator(Counter counter) {
        this.counter = counter;
    }

    @Override
  public void run() {

            while (true) {
                if (counter.getCounter1() > counter.getCounter2()) {
                    System.out.println(this.getName() + " Counter1 more than a Counter2 on: " + (counter.getCounter1() - counter.getCounter2()));
                } else {
                    System.out.println(this.getName() + " Counter2 more than a Counter1 on: " + (counter.getCounter2() - counter.getCounter1()));
                }
                counter.incCounter1();
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.incCounter2();
        }
    }
}
