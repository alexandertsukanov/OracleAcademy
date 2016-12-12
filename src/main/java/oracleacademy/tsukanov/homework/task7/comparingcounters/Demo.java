package oracleacademy.tsukanov.homework.task7.comparingcounters;

public class Demo {

    public static void main(String[] args) {
        Counter counter = new Counter();

        CounterComparator a = new CounterComparator(counter);
        CounterComparator b = new CounterComparator(counter);
        CounterComparator c = new CounterComparator(counter);
        a.start();
        b.start();
        c.start();
    }
}
