package oracleacademy.tsukanov.task6.fileeditor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileEditor {


    static void create(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("File with this name already exist.");
        } else {
            file.createNewFile();
            System.out.println("File was created.");
        }
    }

    static void delete(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
            System.out.println("File was deleted.");
        } else {
            System.out.println("File does not exist.");
        }
    }

    static void rename(String path, String to) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            File rename = new File(to);
            file.renameTo(rename);
        } else {
            System.out.println("File does not exist.");
        }
    }

    static void list(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }
        } else {
            System.out.println("You need to choose the directory!");
        }
    }

    public static void main(String[] args) throws IOException {

        String action;
        Scanner scanner = new Scanner(System.in);

        one:
        do {
            action = scanner.nextLine();
            String[] actions = action.split("\\s+");
            switch (actions[0]) {
                case "create":
                    create(actions[1]);
                    continue one;
                case "delete":
                    delete(actions[1]);
                    continue one;
                case "rename":
                    rename(actions[1], actions[2]);
                    continue one;
                case "list":
                    list(actions[1]);
                    continue one;
                case "exit":
                    System.out.println("Bye, bye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Wrong selection!");
            }
        }
        while (true);
    }
}
