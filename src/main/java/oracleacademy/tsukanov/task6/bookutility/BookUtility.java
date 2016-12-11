package oracleacademy.tsukanov.task6.bookutility;

import java.io.*;
import java.util.ArrayList;

public class BookUtility {

    private static ArrayList<Book> books;

    static ArrayList<Book> bookFromFile(File file) throws FileNotFoundException {
        books = new ArrayList<>();
        String word;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
           while((word = bufferedReader.readLine()) != null){
               String[] format = word.split(";");
               books.add(new Book(format[0],  format[1], Integer.parseInt(format[2])));
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    static void bookToFile(String path) throws IOException{
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            books.forEach(book -> {
                try {
                    bufferedWriter.write(book.getAuthor() + ";" + book.getTitle() + ";" + book.getYear() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
