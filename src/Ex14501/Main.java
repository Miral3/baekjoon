package Ex14501;

/*
문제 이름 : 퇴사
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public  static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] time = new int[N];
    int[] price = new int[N];
    int[] dp = new int[N+1];

    for(int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      time[i] = Integer.parseInt(input[0]);
      price[i] = Integer.parseInt(input[1]);
    }

    for(int i = 0; i < N; i++) {
      if(i + time[i] <= N) {
        dp[i + time[i]] = Math.max(dp[i] + price[i], dp[i + time[i]]);
      }

      dp[i + 1] = Math.max(dp[i + 1], dp[i]);
    }
    System.out.println(dp[N]);

    br.close();
    bw.close();
  }
}
