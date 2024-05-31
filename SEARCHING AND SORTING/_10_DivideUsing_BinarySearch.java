import java.util.*;

public class _10_DivideUsing_BinarySearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Dividend : ");
        int dividend = sc.nextInt();
        System.out.println("Enter a Divisor : ");
        int divisor = sc.nextInt();
        int ans = div(dividend, divisor);
        System.out.println(ans);
        sc.close();
    }

    static int div(int dividend, int divisor) {
        int start = 0, end = dividend, mid, ans = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * divisor <= dividend) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
