package Ex1912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    int max;
    int[] arr = new int[testCase];
    int[] dp = new int[testCase];
    String[] input = br.readLine().split(" ");

    for(int i = 0; i < testCase; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    dp[0] = arr[0];
    max = arr[0];
    for(int i = 1; i < testCase; i++) {
      int caseOne = arr[i] + dp[i-1];
      int caseTwo = arr[i];

      dp[i] = Math.max(caseOne, caseTwo);

      if(max < dp[i]) {
        max = dp[i];
      }
    }

    bw.write(max + "\n");

    br.close();
    bw.close();
  }
}
