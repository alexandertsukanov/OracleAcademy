package oracleacademy.tsukanov.practice.practice5;

import java.io.*;
import java.util.*;

/**
 * Created by tsukanov on 11/29/16.
 */
public class NumberGenerator {


   static void generateNumberInFile(String path, int numbers) throws FileNotFoundException {

        Random rand = new Random();
        try (PrintWriter pw = new PrintWriter(new File(path))){
            for (int i = 0; i < numbers; i++) {

                String a = String.valueOf(rand.nextInt(100));
                pw.append(a);
                pw.append(" ");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void sortNumberInFile(String path) throws FileNotFoundException {
        ArrayList<Integer> sortedNumbers = new ArrayList<>();
        Scanner sc = new Scanner(new File(path));
        while (sc.hasNext()){
            sortedNumbers.add(Integer.parseInt(sc.next()));
        }
        Collections.sort(sortedNumbers);
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(path, false))){
                for(Integer i : sortedNumbers){
                    pw.append(i.toString());
                    pw.append(" ");
                    System.out.println(i);
                }
            } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {


            generateNumberInFile("random.txt", 100);
            sortNumberInFile("random.txt");

    }


}
