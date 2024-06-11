public class _18_UnboundedArraySearch {
    // Find an element in an unbounded array (infinite array)
    // Using Exponential Search
    public static void main(String args[]){
        int arr[] = {3,4,5,6,11,13,14,15,56,70};
        int n = arr.length;
        int key = 13;
        int ind = Exponential(arr, n, key);
        System.out.println(key + " is found at index "+ind);
    }
    //Find interval
    public static int Exponential(int arr[], int n, int key){
        if(arr[0]==key)
        return 0;
        int i = 0, j = 1;
        while(arr[j]<key){
                i = j;
                j = j * 2;
        }
        System.out.println("i = "+i+"\nj = "+j);
        int ans = BinarySearch(arr, i, j, key);
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
