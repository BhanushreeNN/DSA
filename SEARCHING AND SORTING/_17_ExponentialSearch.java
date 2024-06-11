public class _17_ExponentialSearch {

    // Applied for large arrays

    public static void main(String args[]){
        int arr[] = {3,4,5,6,11,13,14,15,56,70};
        int n = arr.length;
        int key = 13;
        int ind = Exponential(arr, n, key);
        System.out.println(key + " is found at index "+ind);
    }

    // Finding the interval for Binary Search (ex. [-,-,-,-,11,13,14,15,56,-])
    // Time Complexity = O(log m)     ----->      m = i(i returned)
    public static int Exponential(int arr[], int n, int key){
        if(arr[0]==key)
        return 0;
        int i = 1;
        while(i<n && arr[i]<=key){
            if(arr[i]==key){
                return i;
            }
            else
            i = i*2;
        }
        System.out.println("start = "+i/2);
        System.out.println("end = "+Math.min(i, n-1)); 
        int ans = BinarySearch(arr, i/2, Math.min(i, n-1), key);
        return ans;
    }
    // Search for the key in the given interval
    // Time Complexity = O(2 ^ (log(m)-1))
    static int BinarySearch(int arr[], int start, int end, int key) {
        int mid;
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
