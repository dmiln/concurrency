package leetcode.algorithm1;

public class SearchInsertPosition35 {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 5, 6};
        int[] a3 = new int[]{1, 3, 5, 6};

        final SearchInsertPosition35 pos = new SearchInsertPosition35();

        System.out.println(pos.searchInsert(a1, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length;

        while (i <= j) {
            final int midIndex = (j - i) / 2 + i;

            if (nums[midIndex] > target) {
                if (midIndex == j)
                {
                    return midIndex;
                }
                j = midIndex;
            } else {
                if (nums[midIndex] < target) {
                    if (midIndex == i)
                    {
                        return midIndex + 1;
                    }
                    i = midIndex;
                } else {
                    return midIndex;
                }
            }
        }

        return i;
    }
}
