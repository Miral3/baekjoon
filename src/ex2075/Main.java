package ex2075;

/*
문제 이름: N번째 큰 수
알고리즘: 자료 구조
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 1;
        int[] idx = new int[n];
        Arrays.fill(idx, n-1);

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int maxIdx = 0;
            for (int j = 0; j < n; j++) {
                if(idx[j] < 0) {
                    continue;
                }
                if(max < arr[idx[j]][j]) {
                    max = arr[idx[j]][j];
                    maxIdx = j;
                }
            }
            if(cnt == n) {
                bw.write(max + "\n");
                break;
            }
            idx[maxIdx]--;
            cnt++;
        }
        br.close();
        bw.close();
    }
}
