package oracleacademy.tsukanov.homework.task4_1;

import java.util.Arrays;

/**
 * Created by tsukanov on 12/2/16.
 */
public class ObjectComparator {


        static Object compare(Object[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }



    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = "C";
        strings[1] = "B";
        strings[2] = "A";

        System.out.println(compare(strings));

        Computer[] computers = new Computer[3];
        computers[0] = new Computer(520, "Dell", 10 );
        computers[1] = new Computer(520, "Asus", 10 );
        computers[2] = new Computer(520, "HP", 10 );

        System.out.println(compare(computers));

        Integer[] integers = new Integer[3];

        integers[0] = 50;
        integers[1] = 15;
        integers[2] = 10;

        System.out.println(compare(integers));

        Car[] cars = new Car[3];

        cars[0] = new Car("BMW", "AX1920", "Alex");
        cars[0] = new Car("Mercedes", "AX2220", "John");
        cars[0] = new Car("Bugatti", "AX9999", "Ralf");

        //Exception!!!
       // System.out.println(compare(cars));


    }
}
