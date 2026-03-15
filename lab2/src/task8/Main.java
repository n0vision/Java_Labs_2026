package task8;

public class Main {

    public static void main(String[] args) {

        // животные
        Dog dog = new Dog("Тузик", 3, "Овчарка");
        Cat cat = new Cat("Пушок", 2, "Сухой корм");
        Bird bird = new Bird("Кеша", 1, true);

        dog.makeSound();
        dog.showBreed();

        cat.makeSound();
        cat.showFood();

        bird.makeSound();
        bird.fly();

        System.out.println();

        // фигуры
        Circle circle = new Circle(6);
        Square square = new Square(7);
        Triangle triangle = new Triangle(3,4,5);

        System.out.println("Круг: площадь = " + circle.getArea() +
                ", периметр = " + circle.getPerimeter());

        System.out.println("Квадрат: площадь = " + square.getArea() +
                ", периметр = " + square.getPerimeter());

        System.out.println("Треугольник: площадь = " + triangle.getArea() +
                ", периметр = " + triangle.getPerimeter());
    }
}