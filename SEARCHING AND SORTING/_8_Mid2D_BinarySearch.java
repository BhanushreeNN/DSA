import java.util.*;

public class _8_Mid2D_BinarySearch {
    // Binary Search in a 2D Array
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println("Enter the key to search : ");
        int key = sc.nextInt();
        search(arr, key);
        sc.close();
    }

    static void search(int arr[][], int key) {
        int n = arr.length, m = arr[0].length;
        int start = 0, end = (n * m) - 1, mid, row, col;
        while (start <= end) {
            mid = start + (end - start) / 2;
            row = mid / m;
            col = mid % m;

            if (arr[row][col] == key) {
                System.out.println("Found at [" + row + "," + col + "]");
                break;
            } else if (arr[row][col] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

}
