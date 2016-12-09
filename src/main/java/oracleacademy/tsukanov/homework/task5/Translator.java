package oracleacademy.tsukanov.homework.task5;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {

    private String getTransaltor(String translatorPath, String filePath) throws FileNotFoundException, UnsupportedEncodingException {
        Pattern p = Pattern.compile("\\w+");
        HashMap<String, String> translation = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(translatorPath), "windows-1251"));
        StringBuilder sb = new StringBuilder();
        String word;
        try {
            while ((word = br.readLine()) != null) {
                System.out.println(word);
                String[] words = word.split(";-;");
                translation.put(words[0], words[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new FileReader(filePath));
        try {
            while ((word = br.readLine()) != null) {
                Matcher m = p.matcher(word);
                while (m.find()) {
                    sb.append((translation.get(m.group().toLowerCase()) + " "));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    void translationMain(String translatorPath, String filePath) throws IOException {

        int action;
        Scanner in = new Scanner(System.in);
        File directory;
        System.out.println("Welcome to Translator!");
        menu:
        do {
            System.out.println("\n"+
            "Please, choose the action:\n"+
            "1. Select dictionary.\n" +
            "2. Exit.\n");
            action = in.nextInt();
            switch (action) {
                case 1:
                    directory = new File(translatorPath);
                    System.out.println();
                    System.out.println("Select translation language:");
                    File[] listOfFiles = directory.listFiles(new FilenameFilter() {
                        @Override
                        public boolean accept(File directory, String name) {
                            return name.matches("\\w\\w-\\w\\w\\.\\w+");
                        }
                    });
                    for (int i = 0; i < listOfFiles.length; i++) {
                        System.out.println(i + ". " + listOfFiles[i].getName().replaceAll("\\.\\w+", ""));
                    }
                    action = in.nextInt();
                    getTransaltor(listOfFiles[action].getAbsolutePath(), filePath);
                    continue menu;
                case 2:
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
        translator.translationMain("/Users/alex/Projects/Java/OracleAcademy/translators", "/Users/alex/Projects/Java/OracleAcademy/translators/English.txt");
    }


}
