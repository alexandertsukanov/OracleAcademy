package oracleacademy.tsukanov.date;

import java.time.LocalDate;
import java.util.Calendar;

import static java.time.temporal.ChronoUnit.*;

public class Date {

    Year year;
    Month month;
    int day;


    class Year {

        boolean isLeap;
        int year;

        Year(int year) {
            this.isLeap = (year % 4 == 0 & year % 100 != 0) | (year % 400 == 0);
            this.year = year;
        }

    }

    class Month {

        int month;

        Month(int month) {

            this.month = month;

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

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", year=" + year +
                ", month=" + month +
                '}';
    }

    enum Day {

        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6),
        SUNDAY(7);

        private final int index;

        Day(int index) {

            this.index = index;

        }

        public static Day valueOf(int index) {
            return Day.values()[index - 1];
        }

    }


    public Date(int day, int month, int year) {

        this.day = day;
        this.month = new Month(month);
        this.year = new Year(year);

    }


    public int getDayOfYear() {

        int dayNo = 0;
        for (int i = 1; i < month.month; i++) {
            System.out.println("Month" + " " + i + " " + month.getDays(i));
            dayNo += month.getDays(i);
        }
        return dayNo += day;
    }

    public Day getDayOfWeek() {

        Calendar c = Calendar.getInstance();
        c.set(year.year, month.month - 1, day - 1);
        int day = c.get(Calendar.DAY_OF_WEEK);
        return Day.valueOf(day);

    }

    public long daysBetween(Date date) {

        LocalDate dateBefore = LocalDate.of(year.year, month.month, day);
        LocalDate dateAfter = LocalDate.of(date.year.year, date.month.month, date.day);
        long daysBetween = DAYS.between(dateBefore, dateAfter);
        return daysBetween;

    }


    public static void main(String[] args) {


        Date a = new Date(1, 12, 2000);
        Date b = new Date(3, 12, 2001);

        System.out.println(a.getDayOfYear());
        System.out.println(a.getDayOfWeek());
        System.out.println(a.daysBetween(b));


    }
}
