package examples_lr6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Example3 {
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition CONDITION = LOCK.newCondition();
    private static int number = 1;

    public static void run() throws InterruptedException {
        number = 1;

        Thread evenThread = new Thread(Example3::runEven, "evenThread");
        Thread oddThread = new Thread(Example3::runOdd, "oddThread");

        evenThread.start();
        oddThread.start();
        evenThread.join();
        oddThread.join();
    }

    private static void runEven() {
        LOCK.lock();
        try {
            while (number <= 10) {
                if (number % 2 == 0) {
                    System.out.println("Чётное: " + number);
                    number++;
                    CONDITION.signalAll();
                } else {
                    CONDITION.await();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            LOCK.unlock();
        }
    }

    private static void runOdd() {
        LOCK.lock();
        try {
            while (number <= 10) {
                if (number % 2 != 0) {
                    System.out.println("Нечётное: " + number);
                    number++;
                    CONDITION.signalAll();
                } else {
                    CONDITION.await();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Пример 3. Чётные и нечётные числа в двух потоках");
        run();
    }
}
