package lr3.task6;

import java.util.ArrayList;

public class CircleArrayList {

    public static int lastRemaining(int n) {
        ArrayList<Integer> people = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }

    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 10_000;
        long t0 = System.nanoTime();
        int survivor = lastRemaining(n);
        long ms = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("ArrayList | N = " + n + " | остался человек с номером " + survivor + " | время: " + ms + " мс");
    }
}
