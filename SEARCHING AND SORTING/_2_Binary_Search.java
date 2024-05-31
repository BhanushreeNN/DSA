import java.util.*;

public class _2_Binary_Search {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array in sorted order : \n");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter the key to search : ");
        int key = sc.nextInt();
        int ans = search(arr, n, key);
        System.out.println("The key is found at index " + (ans));
        sc.close();
    }

    static int search(int arr[], int n, int key) {
        int start = 0, end = n - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}