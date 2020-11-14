package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class heapSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[testCase];

        for(int i = 0;i < testCase; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        /* 힙 생성 알고리즘을 적용하여 힙 구조 생성 */
        for(int i = 1; i < testCase; i++) {
            int child = i;
            do {
                int root = (child - 1) / 2;
                if(arr[root] < arr[child]) {
                    swap(arr, root, child);
                }
                child = root;
            } while(child != 0);
        }
        /* root값과 트리의 마지막 노드와 자리를 바꾸고 반복횟수를 1씩 감소하여 힙 생성 알고리즘을 적용*/
        for(int j = testCase-1; j > 0; j--) {
            swap(arr, 0, j);
            for (int i = 1; i < j; i++) {
                int child = i;
                do {
                    int root = (child - 1) / 2;
                    if (arr[root] < arr[child]) {
                        swap(arr, root, child);
                    }
                    child = root;
                } while (child != 0);
            }
        }

        for(int i = 0; i < testCase; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
