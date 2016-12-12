package oracleacademy.tsukanov.homework.task5.translator;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        Translator translator = new Translator();
        translator.translatorInit("additional/translators", "additional/English.txt", "windows-1251");
    }
}
