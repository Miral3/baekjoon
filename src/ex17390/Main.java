package ex17390;

/*
문제 이름: 이건 꼭 풀어야 해!
알고리즘: 정렬, 누적 합
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
        int q = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }
        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);

            bw.write(arr[r] - arr[l - 1] + "\n");
        }
        br.close();
        bw.close();
    }
}
