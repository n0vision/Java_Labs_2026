package lr3.task6;

import java.util.LinkedList;

public class CircleLinkedList {

    public static int lastRemaining(int n) {
        LinkedList<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.getFirst();
    }

    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 10_000;
        long t0 = System.nanoTime();
        int survivor = lastRemaining(n);
        long ms = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("LinkedList | N = " + n + " | остался человек с номером " + survivor + " | время: " + ms + " мс");
    }
}
