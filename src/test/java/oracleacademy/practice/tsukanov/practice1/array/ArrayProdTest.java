package oracleacademy.practice.tsukanov.practice1.array;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by alex on 11/1/16.
 */
public class ArrayProdTest {

    private static ArrayProd arrayProd;
    static int[] arr = {1,2,3,4,5};

    @BeforeClass
    public static void ArrInit(){
        arrayProd = new ArrayProd(arr);
    }

    @Test
    public void arrProdTest(){

        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            answer *= arr[i] ;
        }
        Assert.assertEquals(answer, ArrayProd.Prod());
        System.out.println(answer);
    }

    @Test(expected = NullPointerException.class)
    public void arrProdException(){

        ArraySum.Sum(null);

    }



}
