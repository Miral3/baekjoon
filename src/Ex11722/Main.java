package Ex11722;

/*
문제 이름 : 가장 긴 감소하는 부분 수열
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
    int[] arr = new int[1001];
    int[] dp = new int[1001];

    String[] input = br.readLine().split(" ");
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int max = 1;
    dp[0] = 1;
    for(int i = 1; i < N; i++) {
      dp[i] = 1;
      for(int j = 0; j < i; j++) {
        if(arr[j] > arr[i] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
      if(max < dp[i]) {
        max = dp[i];
      }
    }

    System.out.println(max);

    br.close();
    bw.close();
  }
}