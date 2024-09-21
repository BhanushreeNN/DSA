public class _10_ZigZagLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node ZigZag(Node head) {

        // Base condition: if list is empty or contains only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Find mid element (last node of first half)
        Node middle = FindMiddle(head);

        // divide
        Node leftHead = head, rightHead = reverse(middle);
        middle.next = null; // break the linked list

        Node nextL, nextR;
        // alternate left and right halves
        while (leftHead != null && rightHead != null) {
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;
            rightHead = nextR;
            leftHead = nextL;
        }

        // merge left and right
        return head;
    }

    public Node reverse(Node midhead) { // O(N)
        Node curr = midhead;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        midhead = prev;
        return midhead;
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
        _10_ZigZagLL ll = new _10_ZigZagLL();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.print("Given Linked list:");
        ll.printList();
        head = ll.ZigZag(head);
        System.out.print("ZigZag Linked list:");
        ll.printList();
    }
}
