import java.util.Scanner;

public class _14_SearchRotatedSortedArray_BinarySearch {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = { 9, 10, 1, 3, 5, 6, 8 };
        int key = 1;
        int ans = search(arr, key);
        System.out.println("The element is " + arr[ans] + " and is found at index " + ans);
        sc.close();
    }
    static int search(int arr[], int key){
        int pivotIndex = findPivot(arr);
        System.out.println("Pivot index = "+pivotIndex);
        if(key>=0 && key<=arr[pivotIndex]){
             //right search
             int ans =  binarySearch(arr, key, pivotIndex+1, arr.length-1);
             return ans;
        }
        else{
            //left search
            int ans =  binarySearch(arr, key, 0, pivotIndex);
            return ans;
        }  
    }
    static int findPivot(int arr[]){
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
    static int binarySearch(int arr[], int key, int start, int end){
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            System.out.println("s = "+start+" e = "+end+" arr[mid] = "+arr[mid]);
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