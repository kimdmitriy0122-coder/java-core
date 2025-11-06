package lesson03;

import lombok.Data;

@Data
public class Car {
    private String country, model;
    private int yearOfManufacture;

    public void printCarInfo() {
        System.out.println("Country: " + country + ", Model: " + model + ", Year of Manufacture: " + yearOfManufacture);
    }
}
