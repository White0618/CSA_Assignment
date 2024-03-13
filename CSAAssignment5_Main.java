package CSA_Assignment5;

import java.util.Random;

public class CSAAssignment5_Main {
    static int[] a = new int[20];

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 20; i++) a[i] = r.nextInt(1000);
        bubbleSort();
        for (int i : a) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < 20; i++) a[i] = r.nextInt(1000);
        insertSort();
        for (int i : a) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < 20; i++) a[i] = r.nextInt(1000);
        quickSort(0,a.length-1);
        for (int i : a) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < 20; i++) a[i] = r.nextInt(1000);
        heapSort();
        for (int i : a) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < 20; i++) a[i] = r.nextInt(1000);
        mergeSort(0,a.length-1);
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }

    public static void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void bubbleSort() {
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - i - 1; j++)
                if (a[j] > a[j + 1]) {
                    flag = false;
                    swap(j, j + 1);
                }
            if (flag) return;
        }
    }

    public static void insertSort() {
        int startIndex = -1;
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1]) {
                startIndex = i + 1;
                break;
            }
        for (int i = startIndex; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) swap(j, j - 1);//小就往左移
        }
    }

    public static void quickSort(int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        while (i != j) {
            for (; j > i && a[j] >= a[l]; j--) ;
            for (; i < j && a[i] <= a[l]; i++) ;
            swap(i, j);
        }
        swap(i, l);
        quickSort(l, i - 1);
        quickSort(i + 1, r);
    }

    public static void heapSort() {
        for (int i = a.length / 2 - 1; i >= 0; i--) down(i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swap(0, i);
            down(0, i);
        }
    }

    public static void down(int f, int size) {
        while (true) {
            int l = 2 * f + 1, r = l + 1, max = f;
            if (l < size && a[l] > a[max]) max = l;
            if (r < size && a[r] > a[max]) max = r;
            if (max == f) return;
            swap(max, f);
            f = max;
        }
    }

    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, mid + 1, right);
        }
    }

    public static void merge(int l, int lEnd, int r, int rEnd) {
        int nl = lEnd - l + 1, nr = rEnd - r + 1;
        int[] L = new int[nl];
        int[] R = new int[nr];
        for (int i = 0; i < nl; i++) L[i] = a[l + i];
        for (int i = 0; i < nr; i++) R[i] = a[r + i];
        int i = 0, j = 0, k = l;
        while (i < nl && j < nr)
            if (L[i] <= R[j]) a[k++] = L[i++];
            else a[k++] = R[j++];
        while (i < nl) a[k++] = L[i++];
        while (j < nr) a[k++] = R[j++];
    }
}