package Ex2193;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public  static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int input = Integer.parseInt(br.readLine());
    long[] dp = new long[10001];

    dp[1] = 1;
    dp[2] = 1;

    for(int i = 3; i <= input; i++) {
      dp[i] = dp[i-2] + dp[i-1];
    }

    bw.write(dp[input] + "");

    br.close();
    bw.close();
  }
}
