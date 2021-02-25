package Ex11052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] cost = new int[N+1];
    int[] dp = new int[N+1];
    String[] input = br.readLine().split(" ");

    for(int i = 0; i < N; i++) {
      cost[i+1] = Integer.parseInt(input[i]);
    }

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= i; j++) {
        dp[i] = Math.max(dp[i], dp[i-j] + cost[j]);
      }
    }
    bw.write(dp[N] + "\n");

    br.close();
    bw.close();
  }
}
