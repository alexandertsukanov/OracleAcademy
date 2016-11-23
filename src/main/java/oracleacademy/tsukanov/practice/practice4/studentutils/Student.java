package oracleacademy.tsukanov.practice.practice4.studentutils;

/**
 * Created by tsukanov on 11/22/16.
 */
public class Student {

    private String firstname;
    private String secondname;
    private int courseNumber;

    public Student(int courseNumber, String firstname, String secondname) {
        this.courseNumber = courseNumber;
        this.firstname = firstname;
        this.secondname = secondname;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
}
