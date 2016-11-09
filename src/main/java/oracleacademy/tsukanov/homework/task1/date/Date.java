package oracleacademy.tsukanov.homework.task1.date;

import java.time.LocalDate;
import java.util.Calendar;
import static java.time.temporal.ChronoUnit.*;

public class Date {
   private Year year;
   private Month month;
   private Day day;

    public Date(int day, int month, int year) {
        this.year = new Year(year);
        this.month = new Month(month);
        this.day = new Day(day);
    }

    class Year {

       private boolean isLeap;
       private int year;

        Year(int year) {
            this.isLeap = (year % 4 == 0 & year % 100 != 0) | (year % 400 == 0);
            this.year = year;
        }

    }

    class Month {

       private int month;

        Month(int month) {
            if(month < 1 || month > 12){
                throw new IllegalArgumentException("Month value should be between 1 and 12.");
            }
            else {
                this.month = month;
            }
        }

        public int getDays(int monthNumber) {
            switch (monthNumber) {
                case 2:
                    return (year.isLeap ? 29 : 28);
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 31;
            }
        }
    }

    class Day{

        private int day;

        public Day(int day) {
            if(month.month == 2 && year.isLeap && (day < 1 || day > 29)){
                throw new IllegalArgumentException("Day value should be between 1 and 29.");
            }
            else if(month.month == 2 && (day < 1 || day > 28)){
                throw new IllegalArgumentException("Day value should be between 1 and 28.");
            }
            else if(month.month == 10 && (day < 1 || day > 30)){
                throw new IllegalArgumentException("Day value should be between 1 and 30.");
            }
            else if(day < 1 || day > 31){
                throw new IllegalArgumentException("Day value should be between 1 and 31.");
            }
            else {
                this.day = day;
            }
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }
    }

    enum DayOfWeek {

        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6),
        SUNDAY(7);

        private final int index;

        DayOfWeek(int index) {
            this.index = index;
        }

        public static DayOfWeek valueOf(int index) {
            if(index < 1 || index > 7){
                throw new IllegalArgumentException("Day week value should be between 1 and 7.");
            }
            else {
                return DayOfWeek.values()[index - 1];
            }
        }
    }

    public int getDayOfYear() {
        int dayNo = 0;
        for (int i = 1; i < month.month; i++) {
            dayNo += month.getDays(i);
        }
        return dayNo += day.day;
    }

    public DayOfWeek getDayOfWeek() {

        Calendar c = Calendar.getInstance();
        c.set(year.year, month.month - 1, day.day - 1);
        int day = c.get(Calendar.DAY_OF_WEEK);
        return DayOfWeek.valueOf(day);

    }

    public long daysBetween(Date date) {

        LocalDate dateBefore = LocalDate.of(year.year, month.month, day.day);
        LocalDate dateAfter = LocalDate.of(date.year.year, date.month.month, date.day.day);
        long daysBetween = DAYS.between(dateBefore, dateAfter);
        return daysBetween;

    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", year=" + year +
                ", month=" + month +
                '}';
    }

    //Test method
    public static void main(String[] args) {

        Date a = new Date(28, 2, 2001);
        Date b = new Date(3, 12, 2001);

        System.out.println(a.getDayOfYear());
        System.out.println(a.getDayOfWeek());
        System.out.println(a.daysBetween(b));
    }
}
