package lr3.task4;

public class LinkedListDemo {

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node current = node1;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
