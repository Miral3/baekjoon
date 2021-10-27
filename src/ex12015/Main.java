package ex12015;

/*
문제 이름: 가장 긴 증가하는 부분 수열 2
알고리즘: 이분 탐색
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dp[0] = arr[0];
        int j = 0;
        for(int i = 1; i < n; i++) {
            if (arr[i] > dp[j]) {
                dp[++j] = arr[i];
            } else {
                int idx = lowerBound(dp, j, arr[i]);
                dp[idx] = arr[i];
            }
        }

        bw.write(j + 1 + "\n");
        br.close();
        bw.close();
    }

    public static int lowerBound(int[] arr, int right, int target) {
        int left = 0;

        while (left < right) {
            int mid = (left + right) / 2;

            if(target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
