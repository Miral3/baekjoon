package Ex1535;

/*
문제 이름 : 안녕
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
    String[] input1 = br.readLine().split(" ");
    String[] input2 = br.readLine().split(" ");

    int[] health = new int[N + 1];
    int[] happiness = new int[N + 1];
    for(int i = 1; i <= N; i++) {
      health[i] = Integer.parseInt(input1[i-1]);
      happiness[i] = Integer.parseInt(input2[i-1]);
    }

    int[] dp = new int[101];
    for(int i = 1; i <= N; i++) {
      for(int j = 99; j >= 0; j--) {
        int hp = health[i] + j;
        if(hp < 100) {
          dp[hp] = Math.max(dp[hp], dp[j] + happiness[i]);
        }
      }
    }

    bw.write(dp[99] + "\n");

    br.close();
    bw.close();
  }
}