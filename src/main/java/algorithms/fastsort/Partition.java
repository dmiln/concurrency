package algorithms.fastsort;

import java.util.Arrays;

public class Partition {
    public static void main(String[] args) {
        Partition p = new Partition();
        int[] sAr = new int[]{5, 5, 8, 7, 6, 5, 4, 3, 2, 1, 0, 5};
        int ind = p.partitionTest(sAr, 0, sAr.length - 1, 5);
        System.out.println(Arrays.toString(sAr));
        System.out.println(ind);
    }

    public void partitionIt(int[] source, int left, int right, int pivot) {
        int l = left;
        int r = right;
        while (true) {
            while (l < right && source[l] < pivot) {
                l++;
            }
            while (r > left && source[r] >= pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(source, l, r);
            l++;
            r--;
        }
    }

    public int partitionEmptyWhile(int[] source, int left, int right, int pivot) {
        int l = left - 1;
        int r = right + 1;
        while (true) {
            while (l < right && source[++l] < pivot);
            while (r > left && source[--r] >= pivot);
            if (l >= r) {
                break;
            }
            swap(source, l, r);
        }
        return l;
    }

    public void swap(int[] source, int i, int j) {
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }

    /*
    Не работает в случае:
    new int[]{5, 5, 8, 7, 6, 5, 4, 3, 2, 1, 0, 5}
    pivot = 5
    5 и 5 поменяются местами и больше не тронутся с места
     */
    public int partitionFromBook(int[] source, int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && source[++leftPtr] < pivot);
            while (rightPtr > left && source[--rightPtr] > pivot);
            if (leftPtr >= rightPtr) {
                break;
            }
            swap(source, leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public int partitionTest(int[] src, int left, int right, int pivot) {
        int l = left - 1;
        int r = right + 1;
        while (true) {
            while (l < right && src[++l] < pivot);
            while (r > left && src[--r] >= pivot);
            if (l >= r) {
                break;
            }
            swap(src, l, r);
        }
        return l;
    }
}
