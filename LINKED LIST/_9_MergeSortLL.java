public class _9_MergeSortLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node mergeSort(Node head) {

        // Base condition: if list is empty or contains only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Find mid element (last node of first half)
        Node middle = FindMiddle(head);

        // divide
        Node leftHead = head, rightHead = middle.next;
        middle.next = null; // break the linked list

        // Sort left and right halves
        leftHead = mergeSort(leftHead); // Sort the left half
        rightHead = mergeSort(rightHead); // Sort the right half

        // merge left and right
        return merge(leftHead, rightHead);
    }

    public Node merge(Node leftHead, Node rightHead) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.data < rightHead.data) {
                temp.next = leftHead;
                temp = temp.next;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                temp = temp.next;
                rightHead = rightHead.next;
            }
        }
        while (leftHead != null) {
            temp.next = leftHead;
            temp = temp.next;
            leftHead = leftHead.next;
        }
        while (rightHead != null) {
            temp.next = rightHead;
            temp = temp.next;
            rightHead = rightHead.next;
        }
        return dummy.next;
    }

    public Node FindMiddle(Node head) { // O(N/2)
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

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
        _9_MergeSortLL ll = new _9_MergeSortLL();
        head = new Node(30);
        head.next = new Node(20);
        head.next.next = new Node(60);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(0);
        System.out.print("Given Linked list:");
        ll.printList();
        head = ll.mergeSort(head);
        System.out.print("Sorted Linked list:");
        ll.printList();
    }
}
