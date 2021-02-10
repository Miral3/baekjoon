package Ex9461;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        int[] N = new int[testCase];

        for(int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            N[i] = input;
        }


        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i < 101; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }

        for(int i = 0; i < testCase; i++) {
            bw.write(dp[N[i]] + "\n");
        }

        br.close();
        bw.close();
    }
}
