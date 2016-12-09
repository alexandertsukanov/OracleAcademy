package oracleacademy.tsukanov.homework.task5;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        Translator translator = new Translator();
        translator.translatorInit("/Users/alex/Projects/Java/OracleAcademy/translators", "/Users/alex/Projects/Java/OracleAcademy/translators/English.txt", "windows-1251");
    }
}
