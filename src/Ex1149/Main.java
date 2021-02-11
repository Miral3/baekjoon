package Ex1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[][] paintCost = new int[testCase][3];
        int[][] dp = new int[testCase][3];

        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            int G = Integer.parseInt(input[1]);
            int B = Integer.parseInt(input[2]);

            paintCost[i][0] = R;
            paintCost[i][1] = G;
            paintCost[i][2] = B;
        }

        dp[0][0] = paintCost[0][0];
        dp[0][1] = paintCost[0][1];
        dp[0][2] = paintCost[0][2];

        for(int i = 1; i < testCase; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + paintCost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + paintCost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + paintCost[i][2];
        }
        System.out.println(Math.min(dp[testCase-1][0],
            Math.min(dp[testCase-1][1], dp[testCase-1][2])));
    }
}
