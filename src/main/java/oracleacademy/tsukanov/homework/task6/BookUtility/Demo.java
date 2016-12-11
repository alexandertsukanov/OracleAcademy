package oracleacademy.tsukanov.homework.task6.BookUtility;

import java.io.File;
import java.io.IOException;

import static oracleacademy.tsukanov.homework.task6.BookUtility.BookUtility.*;

public class Demo {

        public static void main(String args[]) throws IOException {
          File file = new File("books.txt");
          bookFromFile(file).forEach(book -> System.out.println(book.getAuthor() + " " + book.getTitle() + " " + book.getYear()));
          bookToFile("./books1.txt");
    }
}
