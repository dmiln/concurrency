package leetcode.algorithm1;

public class FirstBadVersion278 {

    int fbv = 5;

    public static void main(String[] args) {
        final FirstBadVersion278 bad = new FirstBadVersion278();

        System.out.println(bad.search(166));
    }

    boolean isBadVersion(int version) {
        return version >= fbv;
    }

    // 0 1 2 3 4 5 6 7 8
    // g g g g g b b b b
    public int search(int n) {

        if (n == 1) {
            return n;
        }

        int i = 0;
        int j = n;

        int minBadVersion = j;

        while (i < j) {

            int mid = (j - i) / 2 + i;

            if (isBadVersion(mid)) {
                minBadVersion = mid;
                if (j == mid)
                {
                    break;
                }
                j = mid;
            } else {
                if (i == mid)
                {
                    break;
                }
                i = mid;
            }
        }

        return minBadVersion;

    }
}
