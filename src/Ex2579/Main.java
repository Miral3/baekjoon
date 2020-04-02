package Ex2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] dp = new int[301];
        int[] stair = new int[301];

        for(int i = 1; i <= testCase; i++){
            int input = Integer.parseInt(br.readLine());
            stair[i] = input;
        }

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for(int i = 3; i <= testCase; i++){
            int caseOne = dp[i-2] + stair[i];
            int caseTwo = dp[i-3] + stair[i] + stair[i-1];
            dp[i] = Math.max(caseOne, caseTwo);
        }
        System.out.print(dp[testCase]);
    }
}
