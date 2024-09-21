import java.util.Scanner;

public class _5_RemoveNthNodeFromLast {

// nth node from last = (size - n + 1)th node from first

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void remove(int n) {
        int i = 1, size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++; // calculate size
        }

        if (n == size) {
            head = head.next; // remove first
            return;
        }

        Node prev = head;

        while (i < (size - n)) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public void printList() { // O(N)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        _5_RemoveNthNodeFromLast ll = new _5_RemoveNthNodeFromLast();
        head = new Node(1);
        head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        System.out.print("Given Linked list:");
        ll.printList();
        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();
        ll.remove(n);
        System.out.print("Result Linked list:");
        ll.printList();
    }

}
