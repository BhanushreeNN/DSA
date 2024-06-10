import java.util.ArrayList;
import java.util.List;

public class _16_Find_K_Closest_Elements {
    // 658. Find K Closest Elements
    // https://leetcode.com/problems/find-k-closest-elements/description/
    /*
     * Given a sorted integer array arr, two integers k and x,
     * return the k closest integers to x in the array.
     * The result should also be sorted in ascending order.
     */
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println("Answer(2 pointers - Window Shrink) = " + findClosestElements_2p_Shrink(arr, 4, 3)); // using Two Pointers shrink
        System.out.println("Answer(2 pointers - Window expand) = " + findClosestElements_2p_Expand(arr, 4, 3)); // using Two Pointers expand
        
    }
    public static int lower_bound(int array[], int key){
        int low = 0, high = array.length;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (key <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static List<Integer> findClosestElements_2p_Expand(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int diff[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            diff[i] = Math.abs(arr[i] - x);
        }
        int h = lower_bound(arr, x);
        int l = h - 1;
        while (k > 0) {
            k--;
            if (l < 0)
                h++;
            else if (h >= arr.length)
                l--;
            else if (diff[l] > diff[h])
                h++;
            else
                l--;
        }
        for (int i = l + 1; i < h; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }


    public static List<Integer> findClosestElements_2p_Shrink(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int diff[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            diff[i] = Math.abs(arr[i] - x);
        }

        int l = 0, h = arr.length - 1;
        while ((h - l)  >= k) {
            //greater diff -> move
            if (diff[l] > diff[h])
                l++;
            else
                h--;
        }
        for (int i = l; i <= h; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
