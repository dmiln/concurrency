package leetcode.algorithm1;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {

    public static void main(String[] args) {
        String st = "a1b2";
        LetterCasePermutation784 lcp = new LetterCasePermutation784();
        List<String> listOfString = lcp.letterCasePermutation(st);
        for (String s : listOfString) {
            System.out.println(s);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        perm(s, "", 0, res);
        return res;
    }

    public void perm(String sourceStr, String curPerm, int index, List<String> res) {
        if (curPerm.length() == sourceStr.length()) {
            res.add(curPerm);
            return;
        }

        for (int i = index; i < sourceStr.length(); i++) {
            char symb = sourceStr.charAt(i);
            if (Character.isAlphabetic(symb)) {
                String symbStr = String.valueOf(symb);
                String lowSymb = symbStr.toLowerCase();
                String upSymb = symbStr.toUpperCase();
                String s1 = curPerm + lowSymb;
                String s2 = curPerm + upSymb;
                perm(sourceStr, s1, i + 1, res);
                perm(sourceStr, s2, i + 1, res);
            } else {
                curPerm = curPerm + symb;
                if (curPerm.length() == sourceStr.length()) {
                    res.add(curPerm);
                    return;
                }
            }
        }
    }

}
