package ex2229;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;

public class Main {
    static final int MAX = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[MAX];
        int[] dp = new int[MAX];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            int max = arr[i];
            int min = arr[i];

            for (int j = i; j >= 0; j--) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + max - min);
            }
        }

        bw.write(dp[n] + "\n");
        br.close();
        bw.close();
    }
}
