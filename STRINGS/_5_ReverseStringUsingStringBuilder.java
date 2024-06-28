package STRINGS;

import java.util.*;

public class _5_ReverseStringUsingStringBuilder {
    // Using 2 pointer
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        System.out.println("Enter a string");
        String string = sc.nextLine();
        str.setLength(string.length());
        int l = 0, r = string.length() - 1;
        while (l <= r) {
            char temp = string.charAt(l);
            str.setCharAt(l, string.charAt(r));
            str.setCharAt(r, temp);
            l++;
            r--;
        }
        System.out.println(str);
        sc.close();
    }
}
