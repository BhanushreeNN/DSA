import java.util.*;
public class _7_SquareRoot_Precision_BinarySearch {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        System.out.println("Enter precision : ");
        int p = sc.nextInt();
        double ans = sqrt_bin_precision(n, p);
        System.out.println(ans); 
        sc.close(); 
    }
    static double sqrt_bin_precision(int n, int p){
        int s = 0, e = n, mid, ans = 0;
        while(s<=e){
            mid = s+(e-s)/2;
            if(mid*mid > n){
                e = mid-1;
            }
            else if(mid*mid < n){
                ans = mid;
                s = mid+1;
            }
            else{
                ans = mid;
                break;
            }
        }
        double PrecAns = ans;
        double step = 0.1;
        for(int i = 0; i<p; i++){
            for(double j = PrecAns; (j*j)<=n; j = j+step){
                PrecAns = j;
            }
            step = step/10;
        }
        return PrecAns;
    }
}
