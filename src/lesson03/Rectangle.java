package lesson03;

import lombok.Data;

@Data
public class Rectangle {
    private double width, length;
    public double calculatePerimeter() {
        return (width + length) * 2;
    }
    public double calculateSquare() {
        return width * length;
    }
}
