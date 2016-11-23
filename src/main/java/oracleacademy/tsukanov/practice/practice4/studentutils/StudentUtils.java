package oracleacademy.tsukanov.practice.practice4.studentutils;

import java.util.*;

/**
 * Created by tsukanov on 11/22/16.
 */
public class StudentUtils {


    static Map<String, Student> createMapStudent(List<Student> studentList){
        HashMap<String, Student> studentMap = new HashMap<>();
        for (Student aStudentList : studentList) {
            studentMap.put(aStudentList.getFirstname() + " " + aStudentList.getSecondname(), aStudentList);
        }
        return studentMap;
    }

    static void printStudent(List<Student> studentList, int course){
        Iterator<Student> s = studentList.iterator();
        Student std;
        while (s.hasNext()){
            std = s.next();
            if(std.getCourseNumber() == course){
                System.out.println(std.getFirstname() + " " + std.getSecondname());
            }
        }
    }


    static List<Student> sortStudent(List<Student> studentList){
        studentList.sort((o1, o2) -> o1.getFirstname().compareTo(o2.getFirstname()));
        return studentList;
    }


    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        Student Alex = new Student(1, "Blex", "Tsukanov");
        Student Boris = new Student(2, "Axris", "Tsukanov");
        students.add(Alex);
        students.add(Boris);

        sortStudent(students);
        printStudent(students, 1);

        Iterator<Student> s = students.iterator();
        while(s.hasNext()){
            Student std = s.next();
            System.out.println(std.getFirstname() + " " );
        }

    }

}
