package Ex12852;

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
    int[] dp = new int[1000001];

    dp[2] = 1;
    dp[3] = 1;
    if(N > 3) {
      for(int i = 4; i <= N; i++) {
        int caseOne = dp[i - 1] + 1;
        int caseTwo = dp[i - 1] + 1;
        int caseThr = dp[i - 1] + 1;

        if (i % 2 == 0) {
          caseOne = dp[i / 2] + 1;
        }
        if (i % 3 == 0) {
          caseTwo = dp[i / 3] + 1;
        }

        dp[i] = Math.min(caseOne, Math.min(caseTwo, caseThr));
      }
    }

    bw.write(dp[N] + "\n");

    int i = N;
    bw.write(N + " ");
    while(true) {
      int caseOne = dp[i];
      int caseTwo = dp[i];
      int caseThr = dp[i-1];

      if(i == 1) {
        break;
      }
      if(i % 2 == 0) {
        caseOne = dp[i / 2];
      }
      if (i % 3 == 0) {
        caseTwo = dp[i / 3];
      }
      int min = Math.min(caseOne, Math.min(caseTwo, caseThr));
      if(min == caseOne) {
        i /= 2;
        bw.write(i + " ");
      }
      else if(min == caseTwo) {
        i /= 3;
        bw.write(i + " ");
      }
      else if(min == caseThr){
        i -= 1;
        bw.write(i + " ");
      }
    }

    br.close();
    bw.close();
  }
}