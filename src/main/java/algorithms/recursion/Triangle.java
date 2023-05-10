package algorithms.recursion;

public class Triangle {

    public static void main(String[] args) {
        long start = System.nanoTime();
        int rec = triangle(15000);
        long end = System.nanoTime() - start;
        System.out.println(rec + " time: " + end);
        start = System.nanoTime();
        int bas = triangleBasic(15000);
        end = System.nanoTime() - start;
        System.out.println(bas + " time: " + end);
    }

    public static int triangle(int n) {
        if (n == 1) {
            return 1;
        }
        return n + triangle(n - 1);
    }

    public static int triangleBasic(int n) {
        int total = 0;
        while (n > 0) {
            total += n--;
        }
        return total;
    }

    public void mergeSort(int[] workAround, int low, int top) {
        if (low == top) {
            return;
        }

        int mid = (top - low) / 2 + low;

        mergeSort(workAround, low, mid);
        mergeSort(workAround, mid + 1, top);
        merge(workAround, low, mid + 1, top);
    }

    public void merge(int[] workAround, int lowBound, int mid, int topBound) {
        int i = lowBound;
        int j = mid;
        int c = 0;
        int[] tmp = new int[topBound - lowBound + 1];
        while (i < mid && j <= topBound) {
            if (workAround[i] < workAround[j]) {
                tmp[c++] = workAround[i++];
            } else {
                tmp[c++] = workAround[j++];
            }
        }
        while (i < mid) {
            tmp[c++] = workAround[i++];
        }
        while (j <= topBound) {
            tmp[c++] = workAround[j++];
        }
        System.arraycopy(tmp, 0, workAround, lowBound, tmp.length);
    }
}
