package STRINGS;

public class _4_CheckAnagrams {
    // What are anagrams?
    /*
     * If two strings contain the same characters but in a different order, they can
     * be said to be anagrams. Consider race and care. In this case, race's
     * characters can be formed into a study,or care's characters can be formed into
     * race. Below is a java program to check if two strings are anagrams or not.
     */

    public static void main(String[] args) {
        String str1 = "Care";
        String str2 = "race";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        System.out.println(str1);
    }

}
