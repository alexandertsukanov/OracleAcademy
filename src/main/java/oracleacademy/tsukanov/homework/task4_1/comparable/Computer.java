package oracleacademy.tsukanov.homework.task4_1.comparable;

public class Computer implements Comparable<Computer> {

    String model;
    int ram;
    int hd;

    public Computer(int hd, String model, int ram) {
        this.hd = hd;
        this.model = model;
        this.ram = ram;
    }

    @Override
    public int compareTo(Computer o) {
        return this.model.compareTo(o.model);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "hd=" + hd +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
