

public class _2_ReverseALinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void reverseList(){
        
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
        _2_ReverseALinkedList ll = new _2_ReverseALinkedList();
        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked list:");
        ll.printList();
        
        head = ll.reverseList();

        System.out.print("\nReversed Linked List:");
        ll.printList();
    }
}
