import java.util.*;

public class _6_SquareRoot_BinarySearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        int ans = sqrt_bin(n);
        System.out.println(ans);
        sc.close();
    }

    static int sqrt_bin(int n) {
        int s = 0, e = n, mid, ans = 0;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (mid * mid > n) {
                e = mid - 1;
            } else if (mid * mid < n) {
                ans = mid;
                s = mid + 1;
            } else {
                ans = mid;
                break;
            }

        }
        return ans;
    }
}
