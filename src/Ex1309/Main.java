package Ex1309;

/*
문제 이름 : 동물원
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

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[100001];

    dp[1] = 3;
    dp[2] = 7;
    dp[3] = 17;

    for(int i = 4; i <= N; i++) {
      dp[i] = (dp[i-2] + dp[i-1]*2) % 9901;
    }

    bw.write(dp[N] + "\n");
    br.close();
    bw.close();
  }
}
