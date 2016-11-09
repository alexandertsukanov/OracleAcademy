package oracleacademy.tsukanov.practice.practice1.student;

import java.util.*;

/**
 * Created by alex on 11/1/16.
 */
public class Student {

    private String firstName;
    private String lastName;
    private Group group;
    HashMap<Integer, Exam> exams;

    public HashMap<Integer, Exam> getExams() {
        return exams;
    }

    public void setExams(HashMap<Integer, Exam> exams) {
        this.exams = exams;
    }

    public Student(String firstName, String lastName, Group group) {

        this.exams = new HashMap<Integer, Exam>();
        this.firstName = firstName;
        this.group = group;
        this.lastName = lastName;
    }

    public void markAdd(int id, Exam exam) {

        exams.put(id, exam);

    }

    public void markDelete(int id) {
        if (exams.containsKey(id)) {
            exams.remove(id);
        } else {
            throw new InputMismatchException();
        }
    }


    public int findHighest(String subject){
        int highest = 0;
        for(Map.Entry<Integer, Exam> e : exams.entrySet()){

            if(e.getValue().subject.equals(subject)){
                if(highest < e.getValue().mark){
                    highest = e.getValue().mark;
                }

            }

        }
        return highest;
    }

    public ArrayList<String> findExamsWithMark(int mark) {

        ArrayList<String> examsWithMark = new ArrayList<String>();

        for (Map.Entry<Integer, Exam> e : exams.entrySet()) {


            if (e.getValue().mark == mark ) {
                examsWithMark.add(e.getValue().subject);
            }
        }
        return examsWithMark;
    }

    public double averageMark() {

        double average = 0;
        for (Map.Entry<Integer, Exam> e  : exams.entrySet()) {
            average += e.getValue().mark;
        }
        return average /= exams.size();
    }

    public static void main(String[] args) {

        Group OP = new Group(1, "Finances");

        Student student = new Student("Alex", "Tsukanov", OP);

        Exam Mathematics = new Exam(2, "Mathematics");
        Exam Geometry = new Exam(4, "Geometry");
        Exam Geometry1 = new Exam(5, "Geometry");

        student.markAdd(1, Mathematics);
        student.markAdd(2, Geometry);
        student.markAdd(3, Geometry1);

        System.out.println(student.findHighest("Geometry"));

        System.out.println(student.averageMark());

        student.findExamsWithMark(5);



    }

}
