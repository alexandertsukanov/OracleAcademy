package oracleacademy.practice.tsukanov.practice2;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Parser {


  static HashSet<Notebook> noteBooks = new HashSet<Notebook>();

    public void findNotebooks(File file) throws IOException{

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String findIn = scanner.findInLine("(Ноутбук\\s.{0,35}\\(.{0,10}\\).{0,}кг)");
            String price = scanner.findInLine("(<span\\sclass=\"price\\scost\">\\d*\\sгрн</span>)");
            System.out.println(price);
            if(findIn != null){
                String findIn2 = findIn.replaceAll("(<.{0,}>.{0,}</.{0,}>)|(\".{0,}>)"," ");
                System.out.println(findIn2);

                String[] info = findIn2.split("/", 2);
                Notebook notebook = new Notebook();
                notebook.setModel(info[0]);
                notebook.setDescription(info[1]);
                noteBooks.add(notebook);
            }

            scanner.nextLine();
        }
    }

    public static void main(String[] args) throws IOException{

        File html = new File("source.html");
        Parser parser = new Parser();
        parser.findNotebooks(html);
        for (Notebook n : noteBooks){
            System.out.println(n);
        }

    }

}
