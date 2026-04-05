package lr3.task7;

public class ListFromHead {

    public static void main(String[] args) {
        Node head = null;
        int n = 5;
        for (int i = 1; i <= n; i++) {
            head = new Node(i, head);
        }
        System.out.println("Список, построенный с головы (новый узел — новая голова):");
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
