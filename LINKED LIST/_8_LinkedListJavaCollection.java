import java.util.LinkedList;

public class _8_LinkedListJavaCollection {
    public static void main(String[] args) {
        // CREATE
        // only stores objects
        // int, float, char --> Integer, Float, Character
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(2);
        ll.addLast(3);
        ll.addFirst(1);

        // print --> [ 1 -> 2 -> 3 ]
        System.out.println(ll);

        // remove
        ll.removeLast();
        ll.removeFirst();

        // print --> [ 2 ]
        System.out.println(ll);

    }
}
