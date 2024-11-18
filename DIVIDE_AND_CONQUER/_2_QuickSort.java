package DIVIDE_AND_CONQUER;

public class _2_QuickSort {
    public static void quickSort(int arr[], int si, int ei){
        if(si>=ei) return;
        int part = partition(arr, si,  ei);
        quickSort(arr, si, part-1);
        quickSort(arr, part+1, ei);
    }
    
    // Pivot and Partition
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;
        for (int j = si; j < ei; j++) {
            if (arr[j] < pivot) {
                swap(arr, j, ++i);
            } else {
                continue;
            }
        }
        swap(arr, ei, ++i);
        return i;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void printArr(int arr[]){
        System.out.println();
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 6, 3, 9, 8, 2, 5 };
        printArr(arr);
        quickSort(arr, 0, arr.length-1);
        printArr(arr);

    }

}
