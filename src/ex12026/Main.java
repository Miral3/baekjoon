package ex12026;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            String nowAlphabet = arr[i];
            for(int j = i + 1; j < n; j++) {
                if(nowAlphabet.equals("B")) {
                    if(arr[j].equals("O")) {
                        dp[j] = Math.min(dp[j], dp[i] + (int)Math.pow((j - i), 2));
                    }
                } else if(nowAlphabet.equals("O")) {
                    if(arr[j].equals("J")) {
                        dp[j] = Math.min(dp[j], dp[i] + (int)Math.pow((j - i), 2));
                    }
                } else if(nowAlphabet.equals("J")) {
                    if(arr[j].equals("B")) {
                        dp[j] = Math.min(dp[j], dp[i] + (int)Math.pow((j - i), 2));
                    }
                }
            }
        }

        if(dp[n-1] == Integer.MAX_VALUE) {
            bw.write(-1 + "\n");
        } else {
            bw.write(dp[n-1] + "\n");
        }
        br.close();
        bw.close();
    }
}
