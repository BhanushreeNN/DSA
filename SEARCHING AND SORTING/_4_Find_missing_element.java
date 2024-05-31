public class _4_Find_missing_element { 
    public static void main(String args[]){
        int arr[] = {1,2,4,5};
        int n = arr.length;
        int ans = missing(arr, n);
        System.out.println("The missing element is "+(ans));
     }
     static int missing(int arr[], int n){
        int start = 0, end = n-1, mid;
        int ans = -1;
        while(start<=end){
            mid = start + (end-start)/2;
            if(arr[mid]!=(mid+1)){
                ans = mid+1;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
     }
}