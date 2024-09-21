import java.util.Scanner;

public class _6_CheckPalindromeLL {
     public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node FindMiddle(){ //O(N/2)
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null && slow != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;

    }
    public Node reverse(Node midhead){ // O(N)
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

    public boolean checkPalindrome() {
        Node newhead = reverse(this.FindMiddle());
        Node pt1 = head, pt2 = newhead;
        while(pt1!=null && pt2!=null){
            if(pt1.data!=pt2.data)
            return false;
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        return true;
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
        _6_CheckPalindromeLL ll = new _6_CheckPalindromeLL();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.print("Given Linked list:");
        ll.printList();
        boolean ans = ll.checkPalindrome();
        System.out.print(ans);
        
    }
}
