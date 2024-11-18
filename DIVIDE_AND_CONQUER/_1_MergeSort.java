package DIVIDE_AND_CONQUER;

public class _1_MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 2, 1, 30, 24, 11, 6, 9 };
        mergeSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

    public static void mergeSort(int arr[], int l, int r) {
        if(l>=r) return;
        int mid = l + (r - l) / 2;
        // divide
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    public static void merge(int arr[], int l, int mid, int r){
        int ans[] = new int[r-l+1];
        int k = 0, i = l, j = mid+1;
        while(i<=mid && j<=r){
            if(arr[i]<arr[j]){
                ans[k] = arr[i];
                i++;
            }
            else{
                ans[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            ans[k++] = arr[i++];
        }
        while(j<=r){
            ans[k++] = arr[j++];
        }
        for(int p = 0, s = l; p<ans.length; p++, s++){
            arr[s] = ans[p];
        }
    }
}
