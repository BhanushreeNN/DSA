package STACK;

import java.util.*;

public class _6_GetMidElement {
    public static void getMid(Stack<Integer> stack, int size) { // Recursion
        int curSize = stack.size();
        if(curSize==0){
            System.out.println("There is no element in stack.");
            return;
        }
        if ((size / 2) + 1 == curSize) {
            System.out.println("Middle element : " + stack.peek());
            return;
        }
        int temp = stack.pop();
        getMid(stack, size);
        stack.push(temp);
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int size = stack.size();

        getMid(stack, size);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
