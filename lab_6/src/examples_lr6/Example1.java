package examples_lr6;

import lr6.ThreadDemoConfig;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Example1 {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void run() throws InterruptedException {
        int durationSeconds = ThreadDemoConfig.getNameAndTimeDurationSeconds();
        long delayMs = ThreadDemoConfig.getNumberPrintDelayMs();

        Thread t1 = new Thread(createRunnable("t1", durationSeconds, delayMs), "t1");
        Thread t2 = new Thread(createRunnable("t2", durationSeconds, delayMs), "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static Runnable createRunnable(String name, int durationSeconds, long delayMs) {
        return () -> {
            for (int i = 0; i < durationSeconds; i++) {
                System.out.println(name + " " + LocalTime.now().format(TIME_FORMAT));
                try {
                    Thread.sleep(delayMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Пример 1. Два потока выводят имя и время");
        run();
    }
}
