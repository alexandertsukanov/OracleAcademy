package oracleacademy.practice.tsukanov.junit.student;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class StudentTest {

   static private Student student;


    @BeforeClass
    public static void StudentBefore(){

        student  = new Student("Alex", "Tsukanov", "OOP");
        student.markAdd("Biology", 3);
        student.markAdd("Algebra", 4);
        student.markAdd("Philosophy", 5);

    }


    @Test
    public void markAdd(){


        Assert.assertEquals(3, student.getExams().size());


    }

    @Test(expected = InputMismatchException.class)
    public void markDelete(){

        student.markDelete("Algera");

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

        for (Integer i : student.getExams().values()) {
            average += i;
        }
        average /= student.getExams().size();
        Assert.assertEquals(average, student.averageMark(), 0.1);
    }



}
