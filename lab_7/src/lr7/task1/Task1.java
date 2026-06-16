package lr7.task1;

import examples_lr7.Example1;
import examples_lr7.Example2;
import examples_lr7.Example3;
import examples_lr7.Example4;
import examples_lr7.Example5;
import examples_lr7.Example6;
import examples_lr7.Example7;

public class Task1 {

    public static void run() throws Exception {
        Example1.run();
        System.out.println();

        Example2.run("data");
        System.out.println();

        Example3.run("data");
        System.out.println();

        Example4.run("data");
        System.out.println();

        Example5.run();
        System.out.println();

        Example6.run();
        System.out.println();

        Example7.run();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 1. Воспроизведение всех примеров из раздела 1");
        run();
    }
}
