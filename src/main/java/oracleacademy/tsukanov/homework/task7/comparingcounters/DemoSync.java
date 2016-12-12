package oracleacademy.tsukanov.homework.task7.comparingcounters;

public class DemoSync {

    public static void main(String[] args) {
        CounterSync counter = new CounterSync();

        CounterComparator a = new CounterComparator(counter);
        CounterComparator b = new CounterComparator(counter);
        CounterComparator c = new CounterComparator(counter);
        a.start();
        b.start();
        c.start();
    }
}
