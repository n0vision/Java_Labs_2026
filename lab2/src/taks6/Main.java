package taks6;

public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle(6);
        Square square = new Square(7);
        Triangle triangle = new Triangle(3, 4, 5);

        System.out.println("Круг:");
        System.out.println("Площадь = " + circle.getArea());
        System.out.println("Периметр = " + circle.getPerimeter());

        System.out.println("\nКвадрат:");
        System.out.println("Площадь = " + square.getArea());
        System.out.println("Периметр = " + square.getPerimeter());

        System.out.println("\nТреугольник:");
        System.out.println("Площадь = " + triangle.getArea());
        System.out.println("Периметр = " + triangle.getPerimeter());
    }
}