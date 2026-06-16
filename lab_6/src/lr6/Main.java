package lr6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Лабораторная работа №6: Многопоточность ===\n");

        System.out.println("--- Примеры решения задач ---\n");
        examples_lr6.Example1.main(args);
        System.out.println();

        examples_lr6.Example2.main(args);
        System.out.println();

        examples_lr6.Example3.main(args);
        System.out.println();

        System.out.println("--- Задания для самостоятельной работы ---\n");
        lr6.task1.Task1.main(args);
        System.out.println();

        lr6.task2.Task2.main(args);
        System.out.println();

        lr6.task3.Task3.main(args);
        System.out.println();

        lr6.task4.Task4.main(args);
        System.out.println();

        lr6.task5.Task5.main(args);
        System.out.println();

        lr6.task6.Task6.main(args);
    }
}
