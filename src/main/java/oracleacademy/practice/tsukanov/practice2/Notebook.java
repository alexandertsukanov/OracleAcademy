package oracleacademy.practice.tsukanov.practice2;

/**
 * Created by alex on 11/8/16.
 */
public class Notebook {

   private String model;
   private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Модель: " + model + "\n" +
                "Описание: " + description + "\n\n";
    }
}
