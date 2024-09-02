/*
 * Given a binary string 𝑆 S, you can repeatedly perform an operation where you
 * select an index 𝑖 i such that 𝑆 [ 𝑖 ] = 1 S[i]=1 and 𝑆 [ 𝑖 + 1 ] = 0
 * S[i+1]=0, and then remove exactly 'one' of these characters from 𝑆 S. Your
 * task is to find the smallest possible string 𝑆 S after performing these
 * operations any number of times. If multiple smallest strings are possible,
 * return the lexicographically smallest one.
 */
import java.util.*;
class _1_BinaryString10PairRemoval {
    //-------------------------------------------------------------------------------
    // APPROACH 1 - CHAR ARRAY O(N^2)
    //-------------------------------------------------------------------------------
    // static int n;
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter binary String : ");
    //     String Str = sc.nextLine();
    //     n = Str.length();
    //     char S[] = Str.toCharArray();
    //     char ans[] = binary(S);
    //      System.out.println("size = "+n);
    //     for(int i = 0; i < n; i++){
    //         System.out.print(ans[i] + " ");
    //     }
    // }
    // static char[]  binary(char S[]) {
    //     int flag = 0;
    //     for(int i = 0; i < n-1; i++) {
    //         //check 1 0
    //         if(S[i] == '1' && S[i + 1] == '0') {
    //             flag = 1;
    //             // remove 1
    //             remove(S, i);
    //         }
    //     }
    //     if(flag==0)
    //     return S;
    //     else
    //     return binary(S);
    // }
    // static void remove(char S[], int i) {
    //     for(int j = i; j < n-1; j++){
    //         S[j] = S[j + 1];
    //     }
    //     n--;
    // }
    //-------------------------------------------------------------------------------
    // APPROACH 2 - STRING BUILDER O(N^2)
    //-------------------------------------------------------------------------------
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter binary string: ");
    //     String S = sc.next();
    //     String result = minimizeBinaryString(S);
    //     System.out.println("Smallest possible string: " + result);
    // }
    // static String minimizeBinaryString(String S) {
    //     StringBuilder sb  = new StringBuilder(S);
    //     int flag;
    //     do {
    //         flag = 0;
    //         for(int i = 0; i < sb.length()-1; i++) {
    //             //check 1 0
    //             if(sb.charAt(i) == '1' && sb.charAt(i+1) == '0') {
    //                 flag = 1;
    //                 // remove 1
    //                 sb.deleteCharAt(i);
    //                 break;
    //             }
    //         }
    //     } while (flag==1);
    //     return sb.toString();
    // }
    //-------------------------------------------------------------------------------
    // APPROACH 2 - STRING BUILDER O(N^2)
    //-------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary string: ");
        String S = sc.next();
        String result = minimizeBinaryString(S);
        System.out.println("Smallest possible string: " + result);
    }

    static String minimizeBinaryString(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '1' && c == '0') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}