import java.util.*;

//532. K-diff Pairs in an Array
// https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
/* Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array. */
public class _15_k_diff_elements {
    public static void main(String args[]) {
        int arr[] = { 3, 1, 4, 1, 5 };
        System.out.println("Answer(2 pointers) = " + findPairs2p(arr, 2)); // using Two Pointers
        System.out.println("Answer(Binary Search) = " + findPairsBinSearch(arr, 2));// using Binary Search
        System.out.println("Answer(2 sets) = " + findPairs2Sets(arr, 2));// using 2 sets
    }

    public static int findPairs2Sets(int[] nums, int k) {
        HashSet<Integer> st = new HashSet<>();
        HashSet<Integer> st2 = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] - k;
            if (st.contains(a))
                st2.add(nums[i]);
            st.add(nums[i]);
        }
        return st2.size();
    }

    public static int findPairsBinSearch(int arr[], int k) {
        Arrays.sort(arr);
        Set<Map.Entry<Integer, Integer>> p = new HashSet<>();
        int i = 0;
        while (i < arr.length - 1) {
            int element = arr[i] + k;
            int ind = Arrays.binarySearch(arr, i + 1, arr.length, element);
            if (ind > 0) {
                p.add(Map.entry(arr[i], arr[ind]));
            }
            i++;
        }
        return p.size();
    }

    public static int findPairs2p(int[] arr, int k) {
        Arrays.sort(arr);
        Set<Map.Entry<Integer, Integer>> p = new HashSet<>();
        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[j] - arr[i] == k) {
                p.add(Map.entry(arr[i], arr[j]));
                i++;
                j++;
            } else if ((arr[j] - arr[i]) > k)
                i++;
            else
                j++;
            if (i == j)
                j++;
        }
        return p.size();
    }
}
