package algorithms.fastsort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] mAr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1,};
        int[] sAr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1,};
        ShellSort ss = new ShellSort();
        ss.mergeSort(mAr);
        ss.shellSort(sAr);
        System.out.println(Arrays.toString(mAr));
        System.out.println(Arrays.toString(sAr));
    }

    public void shellSort(int[] source) {
        int h = 1;
        while (h < source.length / 3) {
            h = (h * 3) + 1;
        }

        while (h > 0) {
            for (int outer = h; outer < source.length; outer++) {
                int inner = outer;
                int tmp = source[inner];
                while (inner >= h && tmp < source[inner - h]) {
                    source[inner] = source[inner - h];
                    inner -= h;
                }
                source[inner] = tmp;
            }
            h = (h - 1) / 3;
        }
    }

    public void mergeSort(int[] source) {
        int[] temp = new int[source.length];
        mergeSortInner(source, temp, 0, source.length - 1);
    }

    public void mergeSortInner(int[] source, int[] temp, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortInner(source, temp, left, mid);
        mergeSortInner(source, temp, mid + 1, right);
        merge(source, temp, left, mid + 1, right);
    }

    public void merge(int[] source, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int tI = i;
        while (i < mid && j <= right) {
            if (source[i] < source[j]) {
                temp[tI++] = source[i++];
            } else {
                temp[tI++] = source[j++];
            }
        }
        while (i < mid) {
            temp[tI++] = source[i++];
        }
        while (j <= right) {
            temp[tI++] = source[j++];
        }
        System.arraycopy(temp, left, source, left, right - left + 1);
    }
}
