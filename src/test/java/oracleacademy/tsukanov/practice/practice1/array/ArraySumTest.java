package oracleacademy.tsukanov.practice.practice1.array;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by tsukanov on 11/1/16.
 */
public class ArraySumTest {

    private static ArraySum arraySum;
    static int[] arr = {1,2,3,4,5};

    @BeforeClass
    public static void ArrInit(){
        arraySum = new ArraySum(arr);
    }

    @Test
    public void ArrSumTest(){

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] ;
        }
       Assert.assertEquals(answer, ArraySum.Sum());
    }

    @Test(expected = NullPointerException.class)
    public void ArrSumException(){

         ArraySum.Sum(null);

    }







}
