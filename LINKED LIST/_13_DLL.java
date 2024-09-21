import java.util.Scanner;

public class _13_DLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    // add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If list is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // remove first
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }
        if (head == tail) { // Only one element
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // remove last
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }
        if (head == tail) { // Only one element
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // reverse
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        _13_DLL dll = new _13_DLL();
        Scanner sc = new Scanner(System.in);
        int choice, data;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Remove First");
            System.out.println("4. Remove Last");
            System.out.println("5. Reverse");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to add at the beginning: ");
                    data = sc.nextInt();
                    dll.addFirst(data);
                    break;
                case 2:
                    System.out.print("Enter data to add at the end: ");
                    data = sc.nextInt();
                    dll.addLast(data);
                    break;
                case 3:
                    dll.removeFirst();
                    break;
                case 4:
                    dll.removeLast();
                    break;
                case 5:
                    dll.reverse();
                    break;
                case 6:
                    System.out.print("List contents: ");
                    dll.display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        sc.close();

    }

}
