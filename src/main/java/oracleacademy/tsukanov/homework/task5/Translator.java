package oracleacademy.tsukanov.homework.task5;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {

    private String translate(String translatorPath, String translatableFilePath, String charset) throws FileNotFoundException, UnsupportedEncodingException {
        Pattern p = Pattern.compile("([A-Za-zА-Яа-я0-9ё]+)([\\W]+|$)");
        HashMap<String, String> translation = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(translatorPath), charset));
        StringBuilder sb = new StringBuilder();
        String word;
        try {
            while ((word = br.readLine()) != null) {
                String[] words = word.split("[^a-zA-Zа-яА-Я0-9ё]+");
                for (int i = 0; i < words.length; i++) {
                    translation.put(words[0], words[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(new FileInputStream(translatableFilePath), charset));
        try {
            while ((word = br.readLine()) != null) {
                Matcher m = p.matcher(word);
                while (m.find()) {
                    System.out.println(m.group());
                    if (m.group(1).matches("[A-Z][a-z]+")) {
                        String upperCase = translation.get(m.group(1).toLowerCase());
                        upperCase = Character.toUpperCase(upperCase.charAt(0)) + upperCase.substring(1);
                        sb.append(upperCase);
                    } else {
                        sb.append(translation.get(m.group(1).toLowerCase()));
                    }
                    sb.append(m.group(2));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    void translatorInit(String translatorPath, String translatableFilePath, String charset) throws IOException {
        File directory;
        int action;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Translator!");
        menu:
        do {
            System.out.println("\n" +
                    "Please, choose the action:\n" +
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
                        System.out.println(i + 1 + ". " + listOfFiles[i].getName().replaceAll("\\.\\w+", ""));
                    }
                    action = in.nextInt();
                    String result = translate(listOfFiles[action - 1].getAbsolutePath(), translatableFilePath, charset);
                    System.out.println();
                    System.out.println(result);
                    continue menu;
                case 2:
                    System.out.println("Bye, bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong selection!");
            }
        } while (true);
    }
}
