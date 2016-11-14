package oracleacademy.tsukanov.practice.practice1.array;

/**
 * Created by tsukanov on 11/1/16.
 */
public class ArraySum {

  static int[] arr;

   public ArraySum(int[] arrs){

        arr = arrs;

    }

     public static int Sum(){
         int answer = 0;
         for (int i = 0; i < arr.length; i++) {
            answer += arr[i] ;
         }
         return answer;
   }

    public static int Sum(int[] array){
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            answer += array[i] ;
        }
        return answer;
    }

}
