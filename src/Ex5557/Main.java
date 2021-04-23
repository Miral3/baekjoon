package Ex5557;

/*
문제 이름 : 1학년
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
    int[] num = new int[N+1];
    long[][] dp = new long[101][21];
    String[] input = br.readLine().split(" ");

    for(int i = 1; i <= N; i++) {
      num[i] = Integer.parseInt(input[i-1]);
    }

    dp[1][num[1]]++;
    for(int i = 2; i < N; i++) {
     for(int j = 0; j <= 20; j++) {
       if(j+num[i] <= 20) {
         dp[i][j+num[i]] += dp[i-1][j];
       }
       if(j-num[i] >= 0) {
         dp[i][j-num[i]] += dp[i-1][j];
       }
     }
    }

    bw.write(dp[N-1][num[N]] + "\n");
    br.close();
    bw.close();
  }
}
