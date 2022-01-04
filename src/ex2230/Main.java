package ex2230;

/*
문제 이름: 수 고르기
알고리즘: 정렬, 두 포인터
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        while(left < n && right < n) {
            int dif = arr[right] - arr[left];

            if (dif >= m) {
                result = Math.min(result, dif);
                left++;
            } else {
                right++;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
