package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class countingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[testCase];
        int[] sort = new int[testCase];
        int range;
        int[] arrCount;

        range = 0;
        for(int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
            if(range < arr[i]) {
                range = arr[i];
            }
        }

        arrCount = new int[range + 1];

        for(int i = 0; i < testCase; i++) {
            arrCount[arr[i]]++;
        }

        for(int i = 1; i <= range; i++) {
            arrCount[i] += arrCount[i-1];
        }

        for(int i = testCase-1; i >= 0; i--) {
            sort[arrCount[arr[i]]-1] = arr[i];
            arrCount[arr[i]]--;
        }

        for(int i = 0; i < testCase; i++) {
            System.out.print(sort[i] + " ");
        }
    }
}