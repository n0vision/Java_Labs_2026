package lr3.task7;

public class ListFromTail {

    public static void main(String[] args) {
        Node head = null;
        Node tail = null;
        int n = 5;
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i, null);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        System.out.println("Список, построенный с хвоста (новый узел — новый хвост):");
        printList(head);
    }

    static void printList(Node current) {
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
