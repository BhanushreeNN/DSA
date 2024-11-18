package DYNAMIC_PROGRAMMING;

public class _1_Fibonacci { // O(N) using DP (using recursion, TC = O(2^n))
    public static int fib(int n, int f[]){
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] = fib(n-2, f) + fib(n-1, f);
        return f[n];
    }
    public static void main(String[] args) {
        int n = 6;
        int f[] = new int[n+1];
        System.out.println(fib(n, f));
    }
}
