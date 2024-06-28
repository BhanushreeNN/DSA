package STRINGS;

public class _2_StringCompression {
    // aaabbccccdd --> a3b2c4d2
    // abc --> abc
    // O(n)
    public static void main(String[] args) {
        int count;
        String str = "aaabbccccdd";
        String ans = "";
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            count = 1;
            while(i+1<str.length() && str.charAt(i+1)==ch){
                count++;
                i++;
            }
            ans+=ch;
            if(count>1)
            ans+=count;
        }
        System.out.println(ans);
    }
}
