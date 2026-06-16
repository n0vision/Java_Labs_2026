package lr6.task4;

public class Task4 {

    public static void run() throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            int threadNumber = i + 1;
            threads[i] = new Thread(() -> System.out.println("Поток №" + threadNumber), "thread-" + threadNumber);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Задание 4. Десять потоков выводят свой номер");
        run();
    }
}
