package oracleacademy.tsukanov.homework.task4_1;

import java.util.Arrays;

public class ObjectComparator {
       public static Object compare(Object[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}
