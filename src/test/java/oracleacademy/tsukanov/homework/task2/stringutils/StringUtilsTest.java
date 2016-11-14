package oracleacademy.tsukanov.homework.task2.stringutils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by tsukanov on 11/14/16.
 */
public class StringUtilsTest {

    StringUtils stringUtils = new StringUtils();

    @Test
    public void testReverse() throws Exception {
        String s = "Hello";
        Assert.assertEquals(stringUtils.reverse(s), "olleH");
    }

    @Test
    public void testIsPolindrom() throws Exception {
        String s = "Там холм лохмат";
        Assert.assertEquals(stringUtils.isPolindrom(s), true);
    }

    @Test
    public void testHigher() throws Exception {
        String s1 = "Helloworld!";
        String s2 = "Hell";
        Assert.assertEquals(stringUtils.higher(s1), "Hellow");
        Assert.assertEquals(stringUtils.higher(s2), "Helloooooooo");
    }

    @Test
    public void testWrapWords() throws Exception {
        String s = "Hello world. Java world.";
        Assert.assertEquals(stringUtils.wrapWords(s), "world Hello. world Java.");
    }

    @Test
    public void testContainABC() throws Exception {
        String s1 = "car", s2 = "phone";
        Assert.assertEquals(stringUtils.containABC(s1), true);
        Assert.assertEquals(stringUtils.containABC(s2), false);
    }

    @Test
    public void testIsDate() throws Exception {
        String date1 = "22.12.2016";
        String date2 = "22.13.2016";
        Assert.assertEquals(stringUtils.isDate(date1), true);
        Assert.assertEquals(stringUtils.isDate(date2), false);
    }

    @Test
    public void testIsPostAdress() throws Exception {
        String email1 = "vasya.petrov@gmail.com";
        String email2 = "vasya.petrov@gmail@com";
        Assert.assertEquals(stringUtils.isPostAdress(email1), true);
        Assert.assertEquals(stringUtils.isPostAdress(email2), false);
    }

    @Test
    public void testPhoneFinder() throws Exception {
        ArrayList<String> phones = stringUtils.phoneFinder(new File("phones.txt"), "UTF-8");
        Assert.assertEquals(phones.size(), 4);
    }
}