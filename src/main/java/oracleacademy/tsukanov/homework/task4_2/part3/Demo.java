package oracleacademy.tsukanov.homework.task4_2.part3;

import java.util.Arrays;
import java.util.Iterator;

public class Demo {

        public static void main(String[] args) {

            MyDequeImpl<Integer> myDeque = new MyDequeImpl<Integer>();
            myDeque.addLast(1);
            myDeque.addLast(2);
            myDeque.addLast(3);

            ListIterator<Integer> it2 = myDeque.listIterator();

            //Iterate Forward
            while (it2.hasNext()){
                Integer i = it2.next();
                System.out.print(i + " ");
            }

            System.out.println();

            //Iterate Backward and setting up 5 instead of 3
            while (it2.hasPrevious()){
                Integer i = it2.previous();
                if(i.equals(3)){
                    it2.set(5);
                }
                System.out.print(i + " ");
            }

            //Iterate Forward again
            System.out.println();
            while (it2.hasNext()){
                Integer i = it2.next();
                System.out.print(i + " ");
            }

            System.out.println();

            System.out.println(Arrays.toString(myDeque.toArray()));

        }
}
