package algorithms.recursion;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] ar = {1, 3, 5, 2, 4, 6, 8, 9};
        int[] ints = new int[ar.length];
        ms.merge(ar, ints,0, 3, ar.length - 1);
        System.out.println(Arrays.toString(ar));

        int[] rap = {9, 7, 6, 1, 4, 0, 3, 7, 12, 85, 2};
        ms.sort(rap);
        System.out.println(Arrays.toString(rap));
    }

    public void sort(int[] source) {
        int[] workAround = new int[source.length];
        mergeSort(source, workAround, 0, workAround.length - 1);
    }

    private void mergeSort(int[] src, int[] workAround, int low, int top) {
        if (low == top) {
            return;
        }
        int mid = (low + top) / 2;
        mergeSort(src, workAround, low, mid);
        mergeSort(src, workAround, mid + 1, top);
        merge(src, workAround, low, mid + 1, top);
    }

    private  void merge(int[] src, int[] wordAround, int low, int mid, int top) {
        int i = low;
        int j = mid;
        int c = low;
        while (i < mid && j <= top) {
            if (src[i] < src[j]) {
                wordAround[c++] = src[i++];
            } else {
                wordAround[c++] = src[j++];
            }
        }
        while (i < mid) {
            wordAround[c++] = src[i++];
        }
        while (j <= top) {
            wordAround[c++] = src[j++];
        }
        System.arraycopy(wordAround, low, src, low, top - low + 1);
    }

    public void shellSort(int[] source) {
        int h = 1;
        while (h <= source.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int outer = h; outer < source.length; outer++) {
                int tmp = source[outer];
                int inner = outer;
                while (inner > h - 1 && source[inner - h] >= tmp) {
                    source[inner] = source[inner - h];
                    inner = inner - h;
                }
                source[inner] = tmp;
            }
            h = (h - 1) / 3;
        }
    }
}
