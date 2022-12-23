package ex16507;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);
        int[][] map = new int[r + 1][c + 1];
        long[][] dp = new long[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            int y1 = Integer.parseInt(input[0]);
            int x1 = Integer.parseInt(input[1]);
            int y2 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);
            int size = (Math.abs(y1 - y2) + 1) * (Math.abs(x1 - x2) + 1);
            long sum = dp[y2][x2] - dp[y2][x1-1] - dp[y1-1][x2] + dp[y1-1][x1-1];
            long average = sum / size;
            bw.write(average + "\n");
        }

        br.close();
        bw.close();
    }
}
