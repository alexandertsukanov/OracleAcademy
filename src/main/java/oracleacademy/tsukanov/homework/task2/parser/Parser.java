package oracleacademy.tsukanov.homework.task2.parser;

import java.io.*;
import java.net.URISyntaxException;

/**
 * Created by tsukanov on 11/12/16.
 */
public class Parser {

    public String parseMdToHTML(String from, String to) throws IOException, URISyntaxException{
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(from)));
                FileWriter fileWriter = new FileWriter(to)
        ) {
            stringBuilder.append("<html>\n");
            stringBuilder.append("<body>\n");
            while((s = bufferedReader.readLine()) != null){
                if(s.matches("#+.+")){
                    int count = s.length() - s.replace("#", "").length();
                    stringBuilder.append(s.replaceAll("#+", "<h"+ count + ">"));
                    stringBuilder.append("</h" + count + ">\n");
                }
                else {
                    stringBuilder.append("<p>");
                    stringBuilder.append(s
                            .replaceAll("(\\*{2})(\\w+)(\\*{2})", "<strong>$2</strong>")
                            .replaceAll("((?<=\\s)\\*)(\\w+)(\\*(?=\\s))", "<em>$2</em>")
                            .replaceAll("(\\[)(\\w.+)(\\])(\\()(\\w.+)(\\))", "<a href=\"$5\">$2</a>"));
                    stringBuilder.append("</p>\n");
                }
            }
            stringBuilder.append("</body>\n");
            stringBuilder.append("</html>");
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException, URISyntaxException{

        String a = new Parser().parseMdToHTML("writed.md", "writed.html");
        System.out.println(a);
    }

}
