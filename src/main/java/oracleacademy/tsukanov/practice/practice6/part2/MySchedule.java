package oracleacademy.tsukanov.practice.practice6.part2;

import java.util.HashMap;
import java.util.Map;

public class MySchedule extends Thread {

    public static void showTime(HashMap<Integer, String> intervals){

        for(Map.Entry<Integer, String> value : intervals.entrySet() ){
            for (int i = 0; i < value.getKey(); i++) {
                System.out.println(value.getValue());
            }
        }
    }




    public static void main(String[] args) {



    }
}
