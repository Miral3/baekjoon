package Ex4883;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long idx = 1;

    while(true) {
      int N = Integer.parseInt(br.readLine());
      int[][] arr = new int[N][3];
      long[][] dp = new long[N][3];
      if(N == 0) {
        break;
      }

      for(int i = 0; i < N; i++) {
        String[] input = br.readLine().split(" ");
        for(int j = 0; j < 3; j++) {
          arr[i][j] = Integer.parseInt(input[j]);
          dp[i][j] = Integer.parseInt(input[j]);
        }
      }
      dp[0][2] += dp[0][1];
      dp[1][0] += dp[0][1];
      dp[1][1] += Math.min(dp[1][0],Math.min(dp[0][1], dp[0][2]));
      dp[1][2] += Math.min(dp[0][1], Math.min(dp[1][1], dp[0][2]));

      for (int i = 2; i < N; i++) {
        dp[i][0] += Math.min(dp[i-1][0], dp[i-1][1]);
        dp[i][1] += Math.min(dp[i][0], Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])));
        dp[i][2] += Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][2]));
      }

      bw.write(idx + ". " + dp[N-1][1]+"\n");
      idx++;
    }
    br.close();
    bw.close();
  }
}
