package ex2467;

/*
문제 이름: 용약
알고리즘: 두 포인터
자료구조: 배열
*/

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (left < right) {

            if (Math.abs(min) > Math.abs(arr[left] + arr[right])) {
                min = arr[left] + arr[right];
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (arr[left] + arr[right] < 0) {
                left++;
            } else if (arr[left] + arr[right] > 0) {
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
