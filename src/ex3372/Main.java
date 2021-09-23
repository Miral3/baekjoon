package ex3372;

/*
문제 이름: 보드 점프
알고리즘: 다이나믹 프로그래밍
자료구조: 배열, 빅인티저
*/

import java.io.*;
import java.math.BigInteger;

public class Main {
    static int N;
    static int[][] map;
    static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new BigInteger[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = new BigInteger("-1");
            }
        }

        bw.write(DFS(0, 0) + "\n");
        br.close();
        bw.close();
    }

    public static BigInteger DFS(int x, int y) {
        int num = map[x][y];

        if(x == N-1 && y == N-1) {
            return new BigInteger("1");
        }
        else if(dp[x][y].equals(new BigInteger("-1"))) {
            dp[x][y] = new BigInteger("0");

            int rightx = x;
            int righty = y + num;
            if (rightx >= 0 && righty >= 0 && rightx < N && righty < N) {
                dp[x][y] = dp[x][y].add(DFS(rightx, righty));
            }

            int downx = x + num;
            int downy = y;
            if (downx >= 0 && downy >= 0 && downx < N && downy < N) {
                dp[x][y] = dp[x][y].add(DFS(downx, downy));
            }
        }
        return dp[x][y];
    }
}
