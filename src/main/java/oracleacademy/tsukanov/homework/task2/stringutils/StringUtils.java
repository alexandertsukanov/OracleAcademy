package oracleacademy.tsukanov.homework.task2.stringutils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by tsukanov on 11/11/16.
 */
public class StringUtils {

    public String reverse(String string) {
        String answer = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            answer += string.charAt(i);
        }
        return answer;
    }

    public boolean isPolindrom(String string) {
        String answer = string.replaceAll("\\s+", "");
        String answer2 = reverse(string).replaceAll("\\s+", "");
        return answer.equalsIgnoreCase(answer2);
    }

    public String higher(String string) {
        if (string.length() > 10) {
            return string.substring(0, 6);
        } else {
            for (int i = string.length(); i < 12; i++) {
                string += 'o';
            }
            return string;
        }
    }

    public String wrapWords(String string) {
        String[] arr = string.split("\\.");
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            if(i >= 1){
                answer += " ";
            }
            arr[i] = arr[i].trim();
            String[] space = arr[i].split("\\s+");
            arr[i] = arr[i].replaceAll("^[\\s]\\w+|^\\w+", space[space.length - 1]).replaceAll("\\w+$", space[0]).trim();
            answer += arr[i] + ".";
        }
        return answer;
    }

    public boolean containABC(String string) {
        return string.matches("[abc]+");
    }

    public boolean isDate(String date) {
        return date.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
    }

    public boolean isPostAdress(String string) {
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return string.matches(emailRegex);
    }

    public ArrayList<String> phoneFinder(File file, String charset) throws IOException {
        ArrayList<String> phones = new ArrayList<String>();
        Scanner scanner = new Scanner(file, charset);
        Pattern pattern = Pattern.compile("\\+\\d\\(\\d{3}\\)\\d{4}\\-\\d{2}\\-\\d{2}");
        try {
            while (scanner.hasNext()) {
                if (scanner.hasNext(pattern)) {
                    phones.add(scanner.next());
                } else {
                    scanner.next();
                }
            }
        } catch (InputMismatchException ex) {
            ex.getCause();
        } finally {
            scanner.close();
        }
        return phones;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(new StringUtils().containABC("abcabcacb"));

    }
}
