public class _13_PivotElement_BinarySearch {
    public static void main() {
       int[] var0 = new int[]{9, 10, 1, 3, 5, 6, 8};
       int var1 = search(var0);
       System.out.println("The element is " + var1);
    }
 
    static int search(int[] var0) {
       int var1 = 0;
       int var2 = var0.length - 1;
 
       while(var1 <= var2) {
          int var3 = var1 + (var2 - var1) / 2;
          if (var0[var3] > var0[var3 + 1]) {
             return var3;
          }
 
          if (var0[var1] > var0[var3]) {
             var2 = var3 - 1;
          } else {
             var1 = var3 + 1;
          }
       }
 
       return -1;
    }
 }
 