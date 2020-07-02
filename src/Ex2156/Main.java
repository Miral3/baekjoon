package Ex2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] dp = new int[testCase+1];
        int[] wine = new int[testCase+1];
        int caseOne, caseTwo, caseThr;

        for(int i = 1; i <= testCase; i++){
            int input = Integer.parseInt(br.readLine());
            wine[i] = input;
        }

        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        for(int i = 3; i <= testCase; i++){
            caseOne = dp[i-1];
            caseTwo = dp[i-2] + wine[i];
            caseThr = wine[i-1] + wine[i];
            dp[i] = Math.max(caseOne, Math.max(caseTwo, caseThr));
        }

        System.out.println(dp[testCase]);
    }
}
