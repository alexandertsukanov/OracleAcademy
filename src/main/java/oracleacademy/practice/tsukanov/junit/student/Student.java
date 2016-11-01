package oracleacademy.practice.tsukanov.junit.student;

import java.util.*;

/**
 * Created by alex on 11/1/16.
 */
public class Student {

    private String firstName;
    private String lastName;
    private String group;
    HashMap<String, Integer> exams;

    public HashMap<String, Integer> getExams() {
        return exams;
    }

    public void setExams(HashMap<String, Integer> exams) {
        this.exams = exams;
    }

    public Student(String firstName, String lastName, String group) {

        this.exams = new HashMap<String, Integer>();
        this.firstName = firstName;
        this.group = group;
        this.lastName = lastName;
    }

    public void markAdd(String exam, int mark) {

        exams.put(exam, mark);

    }

    public void markDelete(String exam) {
        if (exams.containsKey(exam)) {
            exams.remove(exam);
        } else {
            throw new InputMismatchException();
        }
    }

    public ArrayList<String> findExamsWithMark(int mark) {

        ArrayList<String> examsWithMark = new ArrayList<String>();

        for (Map.Entry<String, Integer> e : exams.entrySet()) {

            if (e.getValue() == mark) {
                examsWithMark.add(e.getKey());
            }
        }
        return examsWithMark;
    }

    public double averageMark() {

        double average = 0;
        for (Integer i : exams.values()) {
            average += i;
        }
        return average /= exams.size();
    }

    public static void main(String[] args) {

        Student student = new Student("Alex", "Tsukanov", "OOP");
        student.markAdd("Mathematics", 5);
        System.out.println(student.averageMark());
        student.findExamsWithMark(5);
        student.markDelete("Mathematics");

    }

}
