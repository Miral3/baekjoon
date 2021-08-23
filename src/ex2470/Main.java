package ex2470;

/*
문제 이름: 두 용액
알고리즘: 두 포인터, 정렬
자료구조:  배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int[] result = {arr[left], arr[right]};
        int min = 2000000001;
        while(left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if(sum < 0) {
                left++;
            } else if(sum > 0) {
                right--;
            } else {
                result[0] = arr[left];
                result[1] = arr[right];
                break;
            }

        }

        bw.write(result[0] + " " + result[1] + "\n");

        br.close();
        bw.close();
    }
}
