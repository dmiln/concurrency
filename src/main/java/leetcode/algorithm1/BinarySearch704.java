package leetcode.algorithm1;

public class BinarySearch704 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};

        int[] arr2 = new int[]{-1, 0, 3, 5, 9, 12, 15, 17, 21, 36};



        final BinarySearch704 obj = new BinarySearch704();
        System.out.println(obj.search(arr2, 36));
    }

    public int search(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            final int midIndex = (j - i) / 2 + i;

            if (nums[midIndex] > target) {
                j = midIndex - 1;
            } else {
                if (nums[midIndex] < target) {
                    i = midIndex + 1;
                } else {
                    return midIndex;
                }
            }
        }

        return -1;

    }

}
