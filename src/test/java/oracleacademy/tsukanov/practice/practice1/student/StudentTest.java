package oracleacademy.tsukanov.practice.practice1.student;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;

public class StudentTest {

   static private Student student;


    @BeforeClass
    public static void StudentBefore(){

        Group OP = new Group(1, "Finances");
        Exam Mathematics = new Exam(2, "Mathematics");
        Exam Geometry = new Exam(4, "Geometry");

        student  = new Student("Alex", "Tsukanov", OP);

        student.markAdd(1, Mathematics);
        student.markAdd(2, Geometry);

    }


    @Test
    public void markAdd(){


        Assert.assertEquals(2, student.getExams().size());


    }

    @Test(expected = InputMismatchException.class)
    public void markDelete(){

        student.markDelete(6);

    }

    @Test
    public void findExamsWithMark(){

        ArrayList<String> s = new ArrayList<String>();
        s = student.findExamsWithMark(5);
        if(s.isEmpty() || s.size() < 1){
            Assert.fail();
        }


    }

    @Test
    public void averageMark(){

        double average = 0;

        for (Map.Entry<Integer, Exam> e  : student.getExams().entrySet()) {
            average += e.getValue().mark;
        }
        average /= student.getExams().size();
        Assert.assertEquals(average, student.averageMark(), 0.1);
    }



}
