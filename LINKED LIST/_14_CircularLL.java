public class _14_CircularLL {
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node last;

    public void insertEmpty(int data) {
        Node newNode = new Node(data);
        last = newNode;
        newNode.next = last;
    }

    public void insertFirst(int data) {
        if (last == null) {
            insertEmpty(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
    }

    public void insertLast(int data) {
        if (last == null) {
            insertEmpty(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
    }

    public void insertMid(int data, int pos) {
        if (last == null)
            return;
        Node temp = last.next;
        int i = 1;
        while (i < pos - 1) {
            temp = temp.next;
            i++;
            if (temp == last.next) { // Reached back to the start, invalid position
                System.out.println("Invalid Position!!");
                return;
            }
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == last) {
            last = newNode;
        }
    }

    public int deletePosition(int pos) {
        if (last == null) { // Empty list case
            System.out.println("List is empty!");
            return -1;
        }

        Node temp = last.next;
        int i = 1;

        // Special case: Deleting the first node
        if (pos == 1) {
            if (last == last.next) { // Single node case
                int data = last.data;
                last = null; // The list will be empty after this
                return data;
            }
            int data = temp.data;
            last.next = temp.next; // Skip over the first node
            return data;
        }

        // Traverse the list to find the node before the one to be deleted
        while (i < pos - 1) {
            temp = temp.next;
            i++;
            if (temp == last.next) { // Reached back to the start, invalid position
                System.out.println("Invalid Position!!");
                return -1;
            }
        }

        Node toDelete = temp.next;
        temp.next = toDelete.next;

        // If deleting the last node, update the last pointer
        if (toDelete == last) {
            last = temp;
        }

        return toDelete.data;
    }

    public void printList() {
        if (last == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = last.next;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println("(back to start)");
    }

    public static void main(String[] args) {
        _14_CircularLL cll = new _14_CircularLL();
        cll.insertLast(10);
        cll.insertLast(20);
        cll.insertLast(30);
        cll.insertFirst(5);
        cll.insertMid(25, 4);

        System.out.println("Circular Linked List:");
        cll.printList();

        // Delete an element
        System.out.println("Deleted element at position 3: " + cll.deletePosition(3));

        System.out.println("Updated Circular Linked List:");
        cll.printList();
    }
}
