package oracleacademy.homework.tsukanov.car;

/**
 * Created by alex on 11/1/16.
 */
public class Car {



    public static void main(String[] args) {


        Car a = new Car(){

            @Override
            public String toString() {
                return "I am car A";
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };



        Car b = new Car(){
            @Override
            public String toString() {
                return "I am car B";
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };


        System.out.println(a);
        System.out.println(b);

    }

}


