package com.company;


public class HeapSort {


    public static void main(String[] args) {
        int arr[] = {5, 4, 1, 3, 10};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int swap = array[0];
            array[0] = array[i];
            array[i] = swap;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int array[], int n, int i) {

        int largest = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
        }
    }
}
