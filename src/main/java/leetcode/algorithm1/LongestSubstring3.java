package leetcode.algorithm1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring3 {

    public static void main(String[] args) {
        final LongestSubstring3 lobj = new LongestSubstring3();
        System.out.println(lobj.anotherModification("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        String maxNonRepetableStr = "";
        StringBuilder nonRepeatableString = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char curSymbol = s.charAt(i);
            if (nonRepeatableString.toString().contains(String.valueOf(curSymbol))) {
                nonRepeatableString = new StringBuilder();
                int j = i;
                while (--j >= 0) {
                    if (s.charAt(j) == curSymbol) {
                        i = j + 1;
                        break;
                    }
                }
            } else {
                nonRepeatableString.append(curSymbol);
                if (nonRepeatableString.length() > maxNonRepetableStr.length()) {
                    maxNonRepetableStr = nonRepeatableString.toString();
                }
                i++;
            }
        }

        return maxNonRepetableStr.length();
    }

    public int fasterLengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        int maxLength = 0;

        int i = 0;
        while (i < s.length()) {
            char curSymbol = s.charAt(i);
            if (charMap.containsKey(curSymbol)) {
                i = charMap.get(curSymbol) + 1;
                charMap.clear();
            } else {
                charMap.put(curSymbol, i);
                if (charMap.size() > maxLength) {
                    maxLength = charMap.size();
                }
                i++;
            }
        }

        return maxLength;
    }

    public int anotherModification(String s) {
        int maxNonRepeatableStrLength = 0;
        StringBuilder nonRepeatableString = new StringBuilder();

        int i = 0;
        char curSymbol;
        String val;
        while (i < s.length()) {
            curSymbol = s.charAt(i);
            val = String.valueOf(curSymbol);
            if (nonRepeatableString.toString().contains(val)) {
                int repeatableIndex = nonRepeatableString.indexOf(val);
                nonRepeatableString.append(curSymbol);
                nonRepeatableString =
                        new StringBuilder(nonRepeatableString.substring(repeatableIndex + 1));
            } else {
                nonRepeatableString.append(curSymbol);
                if (nonRepeatableString.length() > maxNonRepeatableStrLength) {
                    maxNonRepeatableStrLength = nonRepeatableString.length();
                }
            }
            i++;
        }

        return maxNonRepeatableStrLength;
    }

    public int anotherModificationWithSb(String s) {
        int maxNonRepeatableStrLength = 0;
        StringBuilder nonRepeatableString = new StringBuilder();

        int i = 0;
        char curSymbol;
        int repeatableIndex;
        while (i < s.length()) {
            curSymbol = s.charAt(i);
            if (nonRepeatableString.toString().contains(String.valueOf(curSymbol))) {
                repeatableIndex = nonRepeatableString.toString().indexOf(curSymbol);
                nonRepeatableString.append(curSymbol);
                nonRepeatableString = new StringBuilder(nonRepeatableString.substring(repeatableIndex + 1));
            } else {
                nonRepeatableString.append(curSymbol);
                if (nonRepeatableString.length() > maxNonRepeatableStrLength) {
                    maxNonRepeatableStrLength = nonRepeatableString.length();
                }
            }
            i++;
        }

        return maxNonRepeatableStrLength;
    }
}
