package leetcode.algorithm1;

public class PowerOfTwo231 {

    public static void main(String[] args) {
        PowerOfTwo231 pot = new PowerOfTwo231();
        System.out.println(pot.isPowerOfTwo(1));

        System.out.println(pot.hammingWeight(11111));

        System.out.println(pot.reverseBits(43261596));

        System.out.println(pot.singleNumber(new int[]{2,2,1}));
    }

    public boolean isPowerOfTwo(int n) {

        String binaryString = Integer.toBinaryString(n);
        if (n > 0) {
            int oneCounter = 0;
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    oneCounter++;
                }
            }
            return oneCounter == 1;
        } else {
            return false;
        }
    }

    public int hammingWeight(int n) {
        int counter = 0;
        while (n != 0) {
            if((1 & n) == 1) {
                counter++;
            }
            n = n>>>1;
        }
        return counter;
    }

    public int reverseBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        int res = 0;
        int opCount = 32;
        while (opCount-- != 0) {
            res = res << 1;
            res = (n & 1) ^ res;
            n = n>>>1;
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
