package ex11660;

/*
문제 이름: 구간 합 구하기 5
알고리즘: 다이나믹 프로그래밍, 누적 합
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

        int[][] map = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
                dp[i][j] = dp[i][j - 1] + map[i][j];
            }
        }

        for (int k = 0; k < m; k++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            int sum = 0;

            if(x1 == x2 && y1 == y2) {
                sum = map[x1][y1];
            } else {
                for (int i = x1; i <= x2; i++) {
                    sum += dp[i][y2] - dp[i][y1 - 1];
                }
            }

            bw.write(sum + "\n");
        }

        br.close();
        bw.close();
    }
}
