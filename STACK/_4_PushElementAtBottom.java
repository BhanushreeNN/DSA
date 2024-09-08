package STACK;

import java.util.*;

// Base Case Check: The method pushAtBottom checks if the stack is empty. 
    // If true, it pushes the given data at the bottom of the stack and returns.

// Recursive Pop: If the stack is not empty, it pops the top element (temp) 
    // and recursively calls pushAtBottom with the remaining stack until it finds the bottom.

// Pushing Data at Bottom: When the stack is empty, the data is pushed at the bottom.

// Restoring Stack Order: After pushing data at the bottom, the popped elements (temp) 
    // are pushed back in reverse order, maintaining the original stack order.

// Result in Main: The main method pushes 1, 2, and 3 into the stack, 
    // calls pushAtBottom(4), and then prints the stack from top to bottom (3,2,1,4).

public class _4_PushElementAtBottom {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int temp = s.pop();
        pushAtBottom(s, data);
        s.push(temp);
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        pushAtBottom(stack, 4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
