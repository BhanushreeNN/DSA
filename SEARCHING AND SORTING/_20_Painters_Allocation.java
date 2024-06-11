import java.util.*;

// The Painter's Partition Problem-II
// https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
/*Dilpreet wants to paint his dog's home that has n boards with different lengths. 
The length of ith board is given by arr[i] where arr[] is an array of n integers. 
He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board. */
/*The problem is to find the minimum time to get this job done if all painters start together with 
the constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or only 
board {1} or nothing but not boards {2,4,5}. */

public class _20_Painters_Allocation {
    static long minTime(int[] arr, int n, int k) {
        long maxElement = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            sum += arr[i];
        }

        long start = maxElement;
        long end = sum;
        long ans = end;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossible(arr, n, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    static boolean isPossible(int[] arr, int n, int k, long maxTime) {
        int painterCount = 1;
        long currentTime = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxTime) {
                return false;
            }

            if (currentTime + arr[i] > maxTime) {
                painterCount++;
                currentTime = arr[i];
                if (painterCount > k) {
                    return false;
                }
            } else {
                currentTime += arr[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of boards: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter lengths of the boards: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of painters: ");
        int k = sc.nextInt();

        long result = minTime(arr, n, k);
        System.out.println("Minimum time to paint all boards: " + result);
        /*
         * ex.
         * Enter number of boards: 5
         * Enter lengths of the boards:
         * 5 10 30 20 15
         * Enter number of painters: 3
         * Minimum time to paint all boards: 35
         */
        sc.close();
    }
}
