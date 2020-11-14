package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[testCase];

        for(int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        quickSort(arr, 0, testCase-1);

        for(int i = 0; i < testCase; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        int low, high, pivot;

        pivot = start;
        low = start + 1;
        high = end;

        if(start >= end) {
            return;
        }

        while(low <= high) {
            while (low <= end && arr[low] <= arr[pivot]) {
                low++;
            }
            while (high > start && arr[high] >= arr[pivot]) {
                high--;
            }

            if (low > high) {
                swap(arr, high, pivot);
            } else {
                swap(arr, low, high);
            }
        }
        quickSort(arr, start, high-1);
        quickSort(arr, high+1, end);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
