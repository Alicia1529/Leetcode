import java.io.*;
import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] seq = new int[26];
        for (int i = 0;i<s.length();i++){
            int idx = s.charAt(i) - 'a';
            seq[idx]++;
        }
        for (int i = 0;i<t.length();i++){
            int idx = t.charAt(i) - 'a';
            seq[idx]--;
        }
        for(int i=0;i<26;i++){
            if (seq[i]!=0){
                return false;
            }
        }
        return true;
    }

}
