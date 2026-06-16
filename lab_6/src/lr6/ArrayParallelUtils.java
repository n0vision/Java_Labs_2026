package lr6;

import java.util.concurrent.CountDownLatch;

public final class ArrayParallelUtils {
    private ArrayParallelUtils() {
    }

    public static int parallelMax(int[] array) throws InterruptedException {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int threadCount = Runtime.getRuntime().availableProcessors();
        int chunkSize = (array.length + threadCount - 1) / threadCount;
        int[] partialMax = new int[threadCount];
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int threadIndex = 0; threadIndex < threadCount; threadIndex++) {
            int start = threadIndex * chunkSize;
            int end = Math.min(start + chunkSize, array.length);
            int index = threadIndex;

            if (start >= array.length) {
                partialMax[index] = Integer.MIN_VALUE;
                latch.countDown();
                continue;
            }

            new Thread(() -> {
                int localMax = array[start];
                for (int i = start + 1; i < end; i++) {
                    localMax = Math.max(localMax, array[i]);
                }
                partialMax[index] = localMax;
                latch.countDown();
            }, "max-worker-" + threadIndex).start();
        }

        latch.await();

        int result = partialMax[0];
        for (int i = 1; i < threadCount; i++) {
            result = Math.max(result, partialMax[i]);
        }
        return result;
    }

    public static long parallelSum(int[] array) throws InterruptedException {
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (array.length == 0) {
            return 0L;
        }

        int threadCount = Runtime.getRuntime().availableProcessors();
        int chunkSize = (array.length + threadCount - 1) / threadCount;
        long[] partialSum = new long[threadCount];
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int threadIndex = 0; threadIndex < threadCount; threadIndex++) {
            int start = threadIndex * chunkSize;
            int end = Math.min(start + chunkSize, array.length);
            int index = threadIndex;

            if (start >= array.length) {
                partialSum[index] = 0L;
                latch.countDown();
                continue;
            }

            new Thread(() -> {
                long localSum = 0L;
                for (int i = start; i < end; i++) {
                    localSum += array[i];
                }
                partialSum[index] = localSum;
                latch.countDown();
            }, "sum-worker-" + threadIndex).start();
        }

        latch.await();

        long result = 0L;
        for (long value : partialSum) {
            result += value;
        }
        return result;
    }
}
