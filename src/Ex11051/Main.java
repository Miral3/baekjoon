package Ex11051;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int N;
  static int K;
  static int[][] dp = new int[1001][1001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    K = Integer.parseInt(input[1]);

    bw.write(binomial(N, K) + "\n");

    br.close();
    bw.close();
  }

  public static int binomial(int n, int k) {

    for(int i = 0; i < n+1; i++) {
      dp[i][0] = 1;
    }

    for(int i = 0; i < k+1; i++) {
      dp[i][i] = 1;
    }

    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j < k+1; j++) {
        dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
      }
    }

    return dp[n][k];
  }
}
