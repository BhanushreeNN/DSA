package STRINGS;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/description/
/* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different 
word or phrase, typically using all the original letters exactly once. */


public class _8_ValidAnagram {
    public static void main(String[] args) {
        String s = "nagaram";
        String t = "anagram";
        boolean ans = checkAnagram(s, t);
        System.out.println(ans);
    }

    public static boolean checkAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int count = map.get(c);
            if (count > 1) {
                map.put(c, count - 1);
            } else {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
