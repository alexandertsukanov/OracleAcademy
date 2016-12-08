package oracleacademy.tsukanov.homework.task_5;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Translator {

    static String path;
    File translator;

    private HashMap<String, String> getTransaltor(String path) throws FileNotFoundException {
        HashMap<String, String> translation = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(translator));
        String word;
        try {
            while ((word = br.readLine()) != null) {
                String[] words = word.split(";-;");
                translation.put(words[0], words[1]);
                System.out.println(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return translation;
    }

    void translationMain() throws IOException {

        char action;
        Scanner in = new Scanner(System.in);
        File directory;
        System.out.println("Welcome to Translator!");
        System.out.println("Please, choose the action:");
        System.out.println();
        System.out.println("1. Select dictionary.");
        System.out.println("2. Exit.");
        do {
        action = (char) System.in.read();
        in.nextLine();
        switch (action) {

                case '1':
                    do {
                        System.out.println("Enter translator file path:");
                        path = in.nextLine();
                        directory = new File(System.getProperty("user.home") + path);
                        if (directory.isFile()) {
                            translator = directory;
                            System.out.println(translator);
                        } else if (directory.isDirectory()) {
                            System.out.println("Which exactly?");
                            File[] listOfFiles = directory.listFiles();
                            for (int i = 0; i < listOfFiles.length; i++) {
                                System.out.println(listOfFiles[i].getName());
                            }
                        }
                    } while (!directory.isFile());

                    break;
                case '2':
                    System.out.println("Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong selection!");
            }
        } while (true);
    }

    public static void main(String[] args) throws IOException {
        Translator translator = new Translator();
        translator.translationMain();
    }


}
