public class _11_FindCycle {
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

        // Initialize slow and fast pointers
        Node slow = head;
        Node fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one step
            fast = fast.next.next;    // Move fast pointer by two steps

            // If slow and fast pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        return false; // No cycle
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
        _11_FindCycle ll = new _11_FindCycle();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Introduce a cycle for testing
        head.next.next.next.next.next = head.next;

        // Check if a cycle exists
        if (ll.hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }

        // To avoid infinite loop, we don't print the list when a cycle is detected
    }
}
