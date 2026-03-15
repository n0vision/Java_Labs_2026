package timus.task1044;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int half = N / 2;

        int maxSum = 9 * half;
        long[] count = new long[maxSum + 1];

        int limit = (int) Math.pow(10, half);

        for (int i = 0; i < limit; i++) {
            int x = i;
            int sum = 0;
            for (int j = 0; j < half; j++) {
                sum += x % 10;
                x /= 10;
            }
            count[sum]++;
        }

        long result = 0;
        for (int s = 0; s <= maxSum; s++) {
            result += count[s] * count[s];
        }

        System.out.println(result);
    }
}