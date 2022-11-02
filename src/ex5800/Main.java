package ex5800;

/*
문제 이름: 성적 통계
알고리즘: 구현, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int[] arr = new int[n];
            for (int j = 1; j <= n; j++) {
                arr[j - 1] = Integer.parseInt(input[j]);
            }

            Arrays.sort(arr);

            int min = arr[0];
            int max = arr[n - 1];
            int largestGap = 0;
            for (int j = 1; j < n; j++) {
                largestGap = Math.max(arr[j] - arr[j - 1], largestGap);
            }

            bw.write("Class " + (i + 1) + "\n");
            bw.write("Max " + max + ", Min " + min + ", Largest gap " + largestGap + "\n");
        }
        br.close();
        bw.close();
    }
}
