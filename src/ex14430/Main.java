package ex14430;

/*
문제 이름: 자원 캐기
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int[][] map = new int[r][c];
        int[][] dp = new int[r][c];

        for(int i = 0; i < r; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = map[i][j];
                }
                else if(i == 0) {
                    dp[i][j] = map[i][j] + dp[i][j - 1];
                }
                else if(j == 0) {
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = map[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[r - 1][c - 1]);

        br.close();
        bw.close();
    }
}
