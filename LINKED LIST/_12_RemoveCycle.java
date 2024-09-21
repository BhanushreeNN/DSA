public class _12_RemoveCycle {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to detect if a cycle exists in the linked list
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false; // Empty list or single node can't have a cycle
        }

        Node slow = head;
        Node fast = head;

        // Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Cycle detected
                removeCycle(head, slow); // Remove the cycle
                return true;
            }
        }

        return false; // No cycle
    }

    // Function to remove the cycle from the linked list
    public void removeCycle(Node head, Node meetingPoint) {
        Node slow = head;

        // If the cycle starts from the head, we need to move both pointers until fast reaches the last node of the cycle
        if (slow == meetingPoint) {
            while (meetingPoint.next != slow) {
                meetingPoint = meetingPoint.next;
            }
        } else {
            // Move both pointers at the same pace until they meet at the cycle start point
            while (slow.next != meetingPoint.next) {
                slow = slow.next;
                meetingPoint = meetingPoint.next;
            }
        }

        // Remove the cycle by setting the next of the last node in the cycle to null
        meetingPoint.next = null;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node head;

    public static void main(String[] args) {
        _12_RemoveCycle ll = new _12_RemoveCycle();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Introduce a cycle for testing
        head.next.next.next.next.next = head.next; // 5 -> 2

        // Check if a cycle exists and remove it
        if (ll.hasCycle(head)) {
            System.out.println("Cycle detected and removed.");
        } else {
            System.out.println("No cycle in the linked list.");
        }

        // Print the list after removing the cycle
        System.out.print("Linked list after cycle removal: ");
        ll.printList(head);
    }
}

