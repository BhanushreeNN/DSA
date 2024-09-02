import java.util.Scanner;

public class _1_LinkedListBasics {
    static Scanner sc = new Scanner(System.in);

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public void addFirst(int data) { // O(1)
        // create new node
        Node newNode = new Node(data);
        size++;
        // if list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // new node's next = head
        newNode.next = head;
        // head = new node
        head = newNode;
    }

    public void addLast(int data) { // O(1)
        // create new node
        Node newNode = new Node(data);
        size++;
        // if list is empty
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        // tail node's next = new node
        tail.next = newNode;
        // tail = new node
        tail = newNode;
    }

    public void addNthNode(int idx, int data) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid index.");
            return;
        }
        if (idx == 0) {
            addFirst(data);
            return;
        }
        if (idx == size) {
            addLast(data);
            return;
        }
        // create new node
        Node newNode = new Node(data);
        size++;
        Node temp = head;;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {

        if (size == 0) {
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        } 
        int val = tail.data;
        if (size == 1) {
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        size--;
        prev.next = null;
        tail = prev;
        return val;

    }

    public int removeNthNode(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid index.");
            return Integer.MIN_VALUE;
        }
        if (idx == 0) {
            return removeFirst();
        }
        if (idx == size - 1) {
            return removeLast();
        }
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return val;
    }

    public void printList() { // O(N)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        _1_LinkedListBasics ll = new _1_LinkedListBasics();
        int ch;
        do {
            System.out.println(
                    "------MENU------\n1. Add First\n2. Add Last\n3. Add at nth index\n4. Remove First\n5. Remove Last\n6. Remove at nth index\n7. Print\n8. Exit\n");
            ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    System.out.println("Enter the data to be added at first : ");
                    int data = sc.nextInt();
                    ll.addFirst(data);
                    break;
                }

                case 2: {
                    System.out.println("Enter the data to be added at last : ");
                    int data = sc.nextInt();
                    ll.addLast(data);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the index to be inserted : ");
                    int idx = sc.nextInt();
                    System.out.println("Enter the data to be added at "+idx+" index : ");
                    int data = sc.nextInt();
                    ll.addNthNode(idx, data);
                    break;
                }

                case 4:
                {
                    System.out.println(ll.removeFirst()+" is removed.");
                    break;
                }

                case 5:
                {
                    System.out.println(ll.removeLast()+" is removed.");
                    break;
                }

                case 6:
                {
                    System.out.println("Enter the index to be removed : ");
                    int idx = sc.nextInt();
                    System.out.println(ll.removeNthNode(idx)+" is removed.");
                    break;
                }

                case 7: {
                    ll.printList();
                    System.out.println("size = " + size);
                    break;
                }

                case 8:
                    break;

                default:
                    System.out.println("Wrong Input...");

            }
        } while (ch != 8);

    }

}
