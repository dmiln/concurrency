package algorithms.fastsort;

import leetcode.utils.ArrayUtils;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ar = new int[]{5, 5, 8, 7, 6, 5, 4, 3, 2, 1, 5, 5};

        ar = ArrayUtils.createRandomArray(20, 20);
        QuickSort qs = new QuickSort();
        qs.quickSort(ar);
        System.out.println(Arrays.toString(ar));
    }

    public void quickSort(int[] source) {
        recQuickSort(source, 0, source.length - 1);
    }

    public void recQuickSort(int[] source, int left, int right) {
        if (right - left <= 0) {
            return;
        }
        int pivot = source[right];
        int mid = partitionIt(source, left, right, pivot);
        recQuickSort(source, left, mid - 1);
        recQuickSort(source, mid + 1, right);
    }

    public int partitionIt(int[] source, int left, int right, int pivot) {
        int l = left - 1;
        int r = right;
        while (true) {
            while (l < right && source[++l] < pivot)
                ;
            while (r > left && source[--r] > pivot)
                ;
            if (l >= r) {
                break;
            }
            swap(source, l, r);
        }
        swap(source, l, right);
        return l;
    }

    public void swap(int[] source, int left, int right) {
        int tmp = source[left];
        source[left] = source[right];
        source[right] = tmp;
    }
}
