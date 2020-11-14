package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mergeSort {
    static int[] sorted = new int[8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[testCase];

        for(int i = 0;i < testCase; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        mergeSort(arr, 0, testCase - 1);

        for(int i = 0; i < testCase; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    /* 정렬된 배열을 병합한다 */
    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start; // 분할된 배열 중 비교할 첫번째 배열의 시작 번호
        int j = mid + 1; // // 분할된 배열 중 비교할 두번째 배열호의 시작 번호
        int k = start; // sorted 배열에서 사용될 순서 번호

        /* 분할된 배열들을 비교하여 작은 순서대로 sorted배열에 저장 */
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            }
            else {
                sorted[k++] = arr[j++];
            }
        }

        /* 첫 번째 또는 두 번째 배열의 마지막 번호까지 삽입이 끝났는데 다른 한쪽이 끝나지 않
        았을 경우 나머지를 다 sorted 배열에 삽입한다. */
        if(i > mid) {
            for(int t = j; t <= end; t++) {
                sorted[k++] = arr[t];
            }
        }
        else {
            for(int t = i; t <= mid; t++) {
                sorted[k++] = arr[t];
            }
        }

        /* 정렬된 배열을 삽입한다 */
        for(int t = start; t <= end; t++){
            arr[t] = sorted[t];
        }
    }
    /* 병합 정렬 : 배열을 분할하고 정렬하여 병합한다.*/
    public static void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2; // 중간 위치를 계산;
            mergeSort(arr, start, mid); // 중간 위치를 기준으로 앞쪽 배열 정렬
            mergeSort(arr, mid+1, end); // 중간 위치를 기준으로 뒤쪽 배열 정렬
            merge(arr, start, mid, end); // 정렬된 2개의 배열을 병합
        }
    }
}
