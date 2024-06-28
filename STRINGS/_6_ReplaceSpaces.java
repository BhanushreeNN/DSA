package STRINGS;

import java.util.Scanner;

public class _6_ReplaceSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        System.out.println("Enter a string : ");
        str.append(sc.nextLine());
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                str.setCharAt(i, '@');
            }
        }
        System.out.println(str);
        sc.close();
    }
}
