package oracleacademy.tsukanov.homework.task4_2.part2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Demo {

        public static void main(String[] args) {

            MyDequeImpl<Integer> myDeque = new MyDequeImpl<Integer>();
            myDeque.addFirst(3);
            myDeque.addFirst(4);
            myDeque.addFirst(5);
            myDeque.addFirst(6);

            Iterator<Integer> it2 = myDeque.iterator();

            while (it2.hasNext()){
                Integer i = it2.next();
                if(i.equals(3)){
                    it2.remove();
                }
                System.out.print(i + " ");
            }

            System.out.println();

            for (Integer i : myDeque) {
                System.out.print(i + " ");
            }

            System.out.println();

            System.out.println(Arrays.toString(myDeque.toArray()));


        }
}
