public class _5_MountainArray {
    public static void main(String args[]) {
        int arr[] = { 1, 3, 4, 5, 3, 2 };
        int ans = peakIndexInMountainArray(arr);
        System.out.println("The peak is found at index " + ans);
    }

    static int peakIndexInMountainArray(int[] nums) {
        int s = 0, e = nums.length - 1, mid;
        while (s < e) {
            mid = s + (e - s) / 2;
            if (nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}
