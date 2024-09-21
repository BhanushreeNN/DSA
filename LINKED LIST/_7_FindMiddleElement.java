import java.util.Scanner;

public class _7_FindMiddleElement {
    // TORTOISE AND HARE ALGORITHM
    // The Tortoise and Hare algorithm works because the fast-moving hare reaches
    // the end of the list in exactly the same time it takes for the slow-moving
    // tortoise to reach the middle. When the hare reaches the end, the tortoise is
    // guaranteed to be at the middle of the list.

    // The Tortoise and Hare algorithm leverages two pointers, 'SLOW' and 'FAST',
    // initiated at the beginning of the linked list. The 'SLOW' pointer advances
    // one node at a time, while the 'FAST' pointer moves two nodes at a time.

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public int FindMiddle(){ //O(N/2)
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null && slow != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;

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
        _7_FindMiddleElement ll = new _7_FindMiddleElement();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.print("Given Linked list:");
        ll.printList();
        int middle = ll.FindMiddle();
        System.out.println("middle = "+middle);
    }
}
