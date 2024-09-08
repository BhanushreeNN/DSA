import java.util.Scanner;

public class _4_RecursiveSearch {
    static Scanner sc = new Scanner(System.in);

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printList(Node head) { // O(N)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public int search(int key, Node head) { // O(N)
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = search(key, head.next);
        if (idx == -1)
            return -1;
        return idx+1;
    }

    public static void main(String[] args) {
        _4_RecursiveSearch ll = new _4_RecursiveSearch();
        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked list:");
        ll.printList(head);

        System.out.println("Enter the element to be searched: ");
        int key = sc.nextInt();
        int idx = ll.search(key, head);

        System.out.print("Key found at index = " + idx);
    }
}
