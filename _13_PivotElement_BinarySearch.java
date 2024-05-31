public class _13_PivotElement_BinarySearch {
    // Find the largest element in a sorted and rotated array
    public static void main(String args[]) {
        // int arr[] = { 9, 10, 1, 3, 5, 6, 8 };
        int arr[] = { 1, 3, 5, 6, 8 };
        int ans = search(arr);
        System.out.println("The element is " + arr[ans] + " and is found at index " + ans);
    }

    static int search(int arr[]) {
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (start == end)
                return start;
            if (mid + 1 <= end && arr[mid] > arr[mid + 1]) {
                // answer
                return mid;
            }
            if (mid - 1 >= start && arr[mid - 1] > arr[mid]) {
                // answer
                return mid - 1;
            }
            if (arr[start] > arr[mid]) {
                // search left
                end = mid - 1;
            } else {
                // search right
                start = mid + 1;
            }
        }
        return -1;
    }
}
