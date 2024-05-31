import java.util.*;

public class _9_Searching_Nearly_Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {10,3,40,20,50,80,70};
        for (int a : arr)
            System.out.print(a + " ");
        System.out.println("\nEnter the key element to search : ");
        int key = sc.nextInt();
        int ans = search(arr, key);
        System.out.println("The key is found at index "+(ans));
        sc.close();
    }
    static int search(int arr[], int key){
        int start = 0, end = arr.length-1, mid;
        while(start<=end){
            mid = start + (end - start)/2;
            if(arr[mid]==key){
                return mid;
            }
            if( mid>start && arr[mid-1]==key){
                return mid-1;
            }
            if(mid<end && arr[mid+1]==key){
                return mid+1;
            }
            if (arr[mid]<key) {
                start = mid+2;
            }
            else{
                end = mid-2;
            }
        }
        return -1;
    }
}
