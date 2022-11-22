package ex16926;

/*
문제 이름: 배열 돌리기 1
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);
        int[][] arr = new int[n][m];
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int size = Math.min(n, m) / 2;
        for (int i = 0; i < size; i++) {
            int height = n - ((2 * i) + 1);
            int width = m - ((2 * i) + 1);
            int roundSize = (height * 2) + (width * 2);
            int[] numArr = new int[roundSize];
            int idx = 0;
            for (int j = i; j < n - (i + 1); j++) {
                numArr[idx++] = arr[j][i];
            }
            for (int j = i; j < m - (i + 1); j++) {
                numArr[idx++] = arr[n - (i + 1)][j];
            }
            for (int j = n - (i + 1); j > i; j--) {
                numArr[idx++] = arr[j][m - (i + 1)];
            }
            for (int j = m - (i + 1); j > i; j--) {
                numArr[idx++] = arr[i][j];
            }

            idx = roundSize - (r % roundSize);
            if (r < roundSize) {
                idx = roundSize - r;
            }
            for (int j = i; j < n - (i + 1); j++) {
                result[j][i] = numArr[(idx++) % roundSize];
            }
            for (int j = i; j < m - (i + 1); j++) {
                result[n - (i + 1)][j] = numArr[(idx++) % roundSize];
            }
            for (int j = n - (i + 1); j > i; j--) {
                result[j][m - (i + 1)] = numArr[(idx++) % roundSize];
            }
            for (int j = m - (i + 1); j > i; j--) {
                result[i][j] = numArr[(idx++) % roundSize];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
