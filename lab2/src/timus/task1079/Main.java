package timus.task1079;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int[] a = new int[n + 2];
            a[0] = 0;
            a[1] = 1;
            int max = 1;

            for (int i = 1; 2 * i <= n; i++) {
                a[2 * i] = a[i];
                if (a[2 * i] > max) max = a[2 * i];

                if (2 * i + 1 <= n) {
                    a[2 * i + 1] = a[i] + a[i + 1];
                    if (a[2 * i + 1] > max) max = a[2 * i + 1];
                }
            }

            System.out.println(max);
        }
    }
}
