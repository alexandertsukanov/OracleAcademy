package oracleacademy.tsukanov.practice.practice1.array;

/**
 * Created by alex on 11/1/16.
 */
public class ArrayProd {

    static int[] arr;

    public ArrayProd(int[] arrs){

        arr = arrs;

    }

    public static int Prod(){
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            answer *= arr[i] ;
        }
        return answer;
    }

    public static int Prod(int[] array){
        int answer = 1;
        for (int i = 0; i < array.length; i++) {
            answer *= array[i] ;
        }
        return answer;
    }

}
