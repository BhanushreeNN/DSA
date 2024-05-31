import java.util.*;
public class _1_Linear_Search{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array :");
        for(int i = 0; i<n; i++)
        arr[i] = sc.nextInt();
        System.out.println("Enter the key to search : ");
        int key = sc.nextInt();
        for(int i = 0; i<n; i++){
            if(arr[i]==key){
                System.out.println("Element found at index "+i);
                return;
            }
        }
        System.out.println("Element not found");
        sc.close();
    }
}