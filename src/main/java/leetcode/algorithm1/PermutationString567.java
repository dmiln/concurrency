package leetcode.algorithm1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationString567 {
    public static void main(String[] args) {
        final PermutationString567 ps = new PermutationString567();
        String s1 = "abc";
        String s2 = "ccccbbbbaaaa";
        System.out.println(ps.checkInclusionT(s1, s2));
    }
    public boolean checkInclusionT(String s1, String s2) {
        Set<Character> symbols = new HashSet<>();
        Map<Character, Integer> symbolMap = new HashMap<>();

        int in = -1;
        char symb;
        Integer count;

        for (int i = 0; i < s1.length(); i++) {
            symb = s1.charAt(i);
            symbols.add(symb);

            count = symbolMap.get(symb);
            if (count == null) {
                symbolMap.put(symb, 1);
            } else {
                symbolMap.put(symb, ++count);
            }
        }
        Map<Character, Integer> backupMap = new HashMap<>(symbolMap);

        char tmpSymbol;
        Integer tmpCount;
        for (int i = 0; i < s2.length(); i++) {
            symb = s2.charAt(i);
            if (symbols.contains(symb)) {
                if (in == -1) {
                    in = i;
                }
                count = symbolMap.get(symb);
                if (count == null) {
                    for (int j = in; j < i; j++) {
                        tmpSymbol = s2.charAt(j);
                        if (tmpSymbol == symb) {
                            in = j + 1;
                            break;
                        }
                        tmpCount = symbolMap.get(tmpSymbol);
                        if (tmpCount == null) {
                            symbolMap.put(tmpSymbol, 1);
                        } else {
                            symbolMap.put(tmpSymbol, ++tmpCount);
                        }
                    }
                } else if (count == 1){
                    symbolMap.remove(symb);
                    if (symbolMap.isEmpty()) {
                        return true;
                    }
                } else {
                    symbolMap.put(symb, --count);
                }
            } else {
                in = -1;
                symbolMap = new HashMap<>(backupMap);
            }
        }

        return false;
    }

    //slow variant, but it works
    public boolean checkInclusion(String s1, String s2) {
        StringBuilder res = new StringBuilder(s1);
        int in = -1;
        for (int i = 0; i < s2.length(); i++) {
            String symb = String.valueOf(s2.charAt(i));
            if (res.toString().contains(symb)) {
                if (res.length() == s1.length()) {
                    in = i;
                }
                res = new StringBuilder(res.toString().replaceFirst(symb, ""));
                if (res.length() == 0) {
                    return true;
                }
            } else {
                if (s1.contains(symb)) {
                    int j = s2.indexOf(symb, in);
                    res.append(s2, in, j);
                    in = j + 1;
                } else {
                    res = new StringBuilder(s1);
                    if (in > 0) {
                        in = -1;
                    }
                }
            }
        }
        return false;
    }
}
