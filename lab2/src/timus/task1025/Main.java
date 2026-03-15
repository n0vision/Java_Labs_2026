package timus.task1025;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int needGroups = k / 2 + 1;

        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int result = 0;
        for (int i = 0; i < needGroups; i++) {
            result += a[i] / 2 + 1;
        }

        System.out.println(result);
    }
}