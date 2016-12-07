package oracleacademy.tsukanov.homework.task4_2.part1;

import java.util.Arrays;

public class Demo {

        public static void main(String[] args) {

            MyDeque<Integer> integerMyDeque = new MyDequeImpl<>();
            MyDeque<Integer> integerMyDeque2 = new MyDequeImpl<>();

            integerMyDeque.addFirst(7);
            integerMyDeque.addLast(5);
            integerMyDeque2.addFirst(5);
            integerMyDeque2.addLast(7);

            System.out.println(Arrays.toString(integerMyDeque.toArray()));
            System.out.println(Arrays.toString(integerMyDeque2.toArray()));

            System.out.println(integerMyDeque.containsAll(integerMyDeque2));

            integerMyDeque.removeFirst();
            System.out.println(Arrays.toString(integerMyDeque.toArray()));

            integerMyDeque.addFirst(7);
            System.out.println(Arrays.toString(integerMyDeque.toArray()));

            integerMyDeque2.clear();
            System.out.println(Arrays.toString(integerMyDeque2.toArray()));

            System.out.println(integerMyDeque.toString());
            System.out.println(integerMyDeque.toString());

        }
}
