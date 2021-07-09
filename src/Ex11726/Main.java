package Ex11726;

/*
문제 이름 : 2xn 타일링
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[1001];

    dp[1] = 1;
    dp[2] = 2;

    for(int i = 3; i <= n; i++) {
      dp[i] = (dp[i-1] + dp[i-2]) % 10007;
    }

    System.out.println(dp[n]);

    br.close();
    bw.close();
  }
}