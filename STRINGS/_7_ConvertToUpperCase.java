package STRINGS;

import java.util.Scanner;
// Upper Case to Lower Case
// 'char' - 'a' + 'A'
// ex : 'c' - 'a' + 'A' ==> 99 - 97 + 65 ==> 67 ==> 'C'

// Similarly, Lower Case to Upper Case
// 'char' - 'A' + 'a'
public class _7_ConvertToUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>='a' && str.charAt(i)<='z')
            ans += (char) (str.charAt(i) - 'a' + 'A');
            else
            ans+=str.charAt(i);
        }
        System.out.println(ans);
        sc.close();
    }

}
