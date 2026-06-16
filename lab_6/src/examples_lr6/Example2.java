package examples_lr6;

import lr6.ThreadDemoConfig;

public class Example2 {

    public static void run() throws InterruptedException {
        long delayMs = ThreadDemoConfig.getNumberPrintDelayMs();

        Thread t = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(delayMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "t");

        t.start();
        t.join();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Пример 2. Поток выводит числа от 1 до 10");
        run();
    }
}
