package lr3.task8;

import java.util.Scanner;

public class SinglyLinkedList {

    private Node head;

    public void clear() {
        head = null;
    }

    private int size() {
        int n = 0;
        for (Node p = head; p != null; p = p.next) {
            n++;
        }
        return n;
    }

    public void createHead(Scanner scanner, int n) {
        head = null;
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            head = new Node(v, head);
        }
    }

    public void createTail(Scanner scanner, int n) {
        head = null;
        Node tail = null;
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            Node node = new Node(v, null);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            sb.append(p.value);
            if (p.next != null) {
                sb.append(" -> ");
            }
            p = p.next;
        }
        return sb.toString();
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        if (head == null) {
            head = new Node(value, null);
            return;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(value, null);
    }

    public void insert(int position, int value) {
        int s = size();
        if (position < 1 || position > s + 1) {
            throw new IllegalArgumentException("номер позиции от 1 до " + (s + 1));
        }
        if (position == 1) {
            addFirst(value);
            return;
        }
        if (position == s + 1) {
            addLast(value);
            return;
        }
        Node prev = head;
        for (int i = 1; i < position - 1; i++) {
            prev = prev.next;
        }
        prev.next = new Node(value, prev.next);
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node p = head;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
    }

    public void remove(int position) {
        int s = size();
        if (position < 1 || position > s) {
            throw new IllegalArgumentException("номер от 1 до " + s);
        }
        if (position == 1) {
            removeFirst();
            return;
        }
        if (position == s) {
            removeLast();
            return;
        }
        Node prev = head;
        for (int i = 1; i < position - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    public void createHeadRec(Scanner scanner, int n) {
        head = createHeadRecHelper(scanner, n, null);
    }

    private Node createHeadRecHelper(Scanner scanner, int remaining, Node acc) {
        if (remaining == 0) {
            return acc;
        }
        int v = scanner.nextInt();
        return createHeadRecHelper(scanner, remaining - 1, new Node(v, acc));
    }

    public void createTailRec(Scanner scanner, int n) {
        head = createTailRecHelper(scanner, n, null, null);
    }

    private Node createTailRecHelper(Scanner scanner, int n, Node h, Node t) {
        if (n == 0) {
            return h;
        }
        int v = scanner.nextInt();
        Node node = new Node(v, null);
        if (h == null) {
            return createTailRecHelper(scanner, n - 1, node, node);
        }
        t.next = node;
        return createTailRecHelper(scanner, n - 1, h, node);
    }

    public String toStringRec() {
        return toStringRec(head);
    }

    private String toStringRec(Node node) {
        if (node == null) {
            return "";
        }
        if (node.next == null) {
            return String.valueOf(node.value);
        }
        return node.value + " -> " + toStringRec(node.next);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("createHead: введите 3 целых числа (список строится с головы):");
        list.createHead(sc, 3);
        System.out.println("toString(): " + list);
        list.clear();

        System.out.println("createTail: введите 3 целых числа (список строится с хвоста):");
        list.createTail(sc, 3);
        System.out.println("toString(): " + list);

        list.addFirst(0);
        list.addLast(9);
        System.out.println("addFirst(0), addLast(9): " + list);

        list.insert(2, 99);
        System.out.println("insert(2, 99): " + list);

        list.removeFirst();
        System.out.println("removeFirst(): " + list);

        list.removeLast();
        System.out.println("removeLast(): " + list);

        list.remove(2);
        System.out.println("remove(2): " + list);

        list.clear();
        System.out.println("createHeadRec: введите 3 целых числа:");
        list.createHeadRec(sc, 3);
        System.out.println("toStringRec(): " + list.toStringRec());

        list.clear();
        System.out.println("createTailRec: введите 3 целых числа:");
        list.createTailRec(sc, 3);
        System.out.println("toStringRec(): " + list.toStringRec());

        sc.close();
    }
}
