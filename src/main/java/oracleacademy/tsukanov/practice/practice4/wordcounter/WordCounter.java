package oracleacademy.tsukanov.practice.practice4.wordcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by tsukanov on 11/22/16.
 */
public class WordCounter {

   private static class Counter implements Comparable<Counter>, Comparator<Counter>{

        private int count = 1;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void inc(){
            count++;
        }

        @Override
        public int compareTo(Counter o1) {
            return Integer.compare(count, o1.count);
        }

        @Override
        public int compare(Counter o1, Counter o2) {
          return Integer.compare(o1.count, o2.count);
        }
    }

    enum Sort{

        BYKEY,
        BYKEYDSC,
        BYVALUE,
        BYVALUEDSC;


    }

    static HashMap<String, Counter> countWords(File file) throws IOException{
        HashMap<String, Counter> words = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s = null;
        while( (s = bufferedReader.readLine()) != null){
            String[] splitted = s.split(" ");
            for (String aSplitted : splitted) {
                if (aSplitted.matches("\\w*|\\w*\\-|\\w*'\\w*[^\\,.;\\s+\\?\\!:;\\[\\]-]")) {
                    if(words.get(aSplitted) == null) {
                        words.put(aSplitted, new Counter());
                    }
                    else{
                        words.get(aSplitted).inc();
                    }
                }
            }
        }
        return words;
    }

    static LinkedHashMap<String, Counter> countWords(File file, Sort sort) throws IOException{
        LinkedHashMap<String, Counter> words = new LinkedHashMap<>();
        LinkedHashMap<String, Counter> sorted = new LinkedHashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s = null;
        while( (s = bufferedReader.readLine()) != null){
            String[] splitted = s.split(" ");
            for (String aSplitted : splitted) {
                if (aSplitted.matches("[\\w]*[\\w'\\w]*[\\w-\\w]*[^\\,.;\\s+\\?\\!:;\\[\\]-]")) {
                    if(words.get(aSplitted) == null) {
                        words.put(aSplitted, new Counter());
                    }
                    else{
                        words.get(aSplitted).inc();
                    }
                }
            }
        }
        switch (sort){

            case BYKEY:
                words.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(o -> sorted.put(o.getKey(), o.getValue()));
                break;
            case BYKEYDSC:
                words.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(o -> sorted.put(o.getKey(), o.getValue()));
                break;
            case BYVALUE:
                words.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .forEach(o -> sorted.put(o.getKey(), o.getValue()));
                break;
            case BYVALUEDSC:
                words.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                        .forEach(o -> sorted.put(o.getKey(), o.getValue()));
                break;
        }
        return sorted;
    }



    public static void main(String[] args) throws IOException{

//        File words = new File("Romeo.txt");
//        HashMap<String, Counter> counted = countWordsWithSort(words, Sort.BYKEY);
//
//        for(Map.Entry <String, Counter> s : counted.entrySet()){
//            System.out.printf("%-20.20s  %-20.20s%n", s.getKey(), s.getValue().getCount());
//        }

        System.out.printf("%2s %1s", "ds", "ome");
    }
}
