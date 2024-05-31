import java.util.Scanner;

public class _12_UniqueElement_BinarySearch {
    // Find odd occurring element
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 4, 3, 3, 2, 600, 600, 4, 4 };
        int ans = search(arr);
        System.out.println("Unique element is " + arr[ans] + " found at index " + ans);
        sc.close();
    }

    static int search(int arr[]) {
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (start == end)
                return start;
            if (mid % 2 == 0) {
                // index is even
                if (arr[mid] == arr[mid + 1])
                    start = mid + 2;
                else
                    end = mid; // answer is mid / or mid is at the right of answer
            } else {
                // index is odd
                if (arr[mid] == arr[mid + 1])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }

}
