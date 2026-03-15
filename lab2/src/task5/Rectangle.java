package task5;

public class Rectangle {

    // поля класса
    private double length;
    private double width;

    // конструктор
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // методы установки значений
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // методы получения значений
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // метод вычисления площади
    public double getArea() {
        return length * width;
    }

    // метод вычисления периметра
    public double getPerimeter() {
        return 2 * (length + width);
    }
}