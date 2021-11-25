package ex1633;

/*
문제 이름: 최고의 팀 만들기
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] white = new int[1001];
    static int[] black = new int[1001];
    static int[][][] dp = new int[1001][16][16];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = br.readLine()) != null) {
            String[] arr = input.split(" ");
            int whiteNum = Integer.parseInt(arr[0]);
            int blackNum = Integer.parseInt(arr[1]);

            white[idx] = whiteNum;
            black[idx] = blackNum;

            idx++;
        }

        System.out.println(dfs(0, 0, 0));
        br.close();
        bw.close();
    }

    public static int dfs(int whiteCnt, int blackCnt, int depth) {
        if(whiteCnt == 15 && blackCnt == 15) {
            return 0;
        }
        if (idx == depth) {
            return 0;
        }

        if(dp[depth][whiteCnt][blackCnt] != 0) {
            return dp[depth][whiteCnt][blackCnt];
        }

        int max = dfs(whiteCnt, blackCnt, depth + 1);

        if (whiteCnt < 15) {
            max = Math.max(max, dfs(whiteCnt + 1, blackCnt, depth + 1) + white[depth]);
        }
        if (blackCnt < 15) {
            max = Math.max(max, dfs(whiteCnt, blackCnt + 1, depth + 1) + black[depth]);
        }

        dp[depth][whiteCnt][blackCnt] = max;
        return dp[depth][whiteCnt][blackCnt];
    }
}
