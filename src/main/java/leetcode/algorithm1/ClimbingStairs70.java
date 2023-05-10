package leetcode.algorithm1;

public class ClimbingStairs70 {

    public static void main(String[] args) {
        ClimbingStairs70 cs = new ClimbingStairs70();
        System.out.println(cs.climbStairs(5));

        System.out.println(cs.solveArrayProblemTwoPointers(new char[]{'b', 'c', 'e'}));

    }

    public char solveArrayProblem(char[] wrongAlphabetSeq) {
        String alphabetStr = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet;
        if (Character.isUpperCase(wrongAlphabetSeq[0])) {
            alphabet = alphabetStr.toUpperCase().toCharArray();
        } else {
            alphabet = alphabetStr.toCharArray();
        }
        int ind = 0;
        while (ind < alphabet.length && alphabet[ind] != wrongAlphabetSeq[0]) {
            ind++;
        }
        for (int i = ind, j = 0; i < alphabet.length && j < wrongAlphabetSeq.length; i++, j++) {
            if (alphabet[i] != wrongAlphabetSeq[j]) {
                return alphabet[i];
            }
        }
        return 0;
    }
    public char solveArrayProblemTwoPointers(char[] wrongAlphabetSeq) {
        int i = 1;
        while (i < wrongAlphabetSeq.length) {
            if (wrongAlphabetSeq[i] - wrongAlphabetSeq[i -1] > 1) {
                return (char)(wrongAlphabetSeq[i] - 1);
            }
            i++;
        }
        return 0;
    }


    public int climbStairs(int n) {
        int[] a = new int[2];

        if (n < 3) {
            return n;
        }

        a[0] = 1;
        a[1] = 2;

        for (int i = 2; i < n; i++) {
            int ind = i % 2;
            a[ind] = a[1] + a[0];
        }
        return a[(n - 1) % 2];
    }
}
