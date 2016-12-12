package oracleacademy.tsukanov.homework.task7.comparingcounters;

public class Counter {

  private int counter1 = 0;
  private int counter2 = 0;

   void incCounter1(){
          counter1++;
    }

   void incCounter2(){
         counter2++;
    }

    public int getCounter1() {
        return counter1;
    }

    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }

    public int getCounter2() {
        return counter2;
    }

    public void setCounter2(int counter2) {
        this.counter2 = counter2;
    }
}
