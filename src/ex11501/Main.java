package ex11501;

/*
문제 이름: 주식
알고리즘: 그리디
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            int max = 0;
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                } else {
                    sum += max - arr[i];
                }
            }

            bw.write(sum + "\n");
        }

        br.close();
        bw.close();
    }
}
