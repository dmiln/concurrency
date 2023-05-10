package leetcode.may;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberVowels1456 {

    public static void main(String[] args) {
        MaximumNumberVowels1456 m = new MaximumNumberVowels1456();
        System.out.println(m.maxVowels("weallloveyou", 7));
    }

    public int maxVowels(String s, int k) {
        Set<Character> vows = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int curL = 0;
        for (int i = 0; i < k; i++) {
            char symb = s.charAt(i);
            if (vows.contains(symb)) {
                curL++;
            }
        }
        int max = curL;
        for (int i = k; i < s.length(); i++) {
            char newSymb = s.charAt(i);
            if (vows.contains(newSymb)) {
                curL++;
            }
            char delSymb = s.charAt(i - k);
            if (vows.contains(delSymb)) {
                curL--;
            }
            if (curL > max) {
                max = curL;
            }
        }
        return max;
    }

}

