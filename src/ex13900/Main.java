package ex13900;

/*
문제 이름: 순서쌍의 곱의 합
알고리즘: 수학, 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[] sum = new long[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        sum[0] = arr[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        long result = 0;
        for(int i = 0; i < n; i++) {
            result += (sum[n - 1] - sum[i]) * arr[i];
        }

        System.out.println(result);

        br.close();
        bw.close();
    }

}
