package oracleacademy.tsukanov.homework.task4_2.part2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Demo {

        public static void main(String[] args) {

            MyDequeImpl<Integer> objects = new MyDequeImpl<Integer>();
            objects.addFirst(1);
            objects.addFirst(2);
            objects.addFirst(3);
            objects.addFirst(4);
            objects.addFirst(5);

            Iterator it2 = objects.iterator();

            while (it2.hasNext()){
                Integer a = (Integer) it2.next();
                if(a.equals(2) || a.equals(4))
                {
                    it2.remove();
                }
            }

            System.out.println(Arrays.toString(objects.toArray()));


        }
}
