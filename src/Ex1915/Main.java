package Ex1915;

/*
문제 이름 : 가장 큰 정사각형
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

    int[][] map = new int[1001][1001];
    int[][] dp = new int[1001][1001];
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    for(int i = 1 ; i <= n; i++) {
      input = br.readLine().split("");
      for(int j = 1; j <= m; j++) {
        map[i][j] = Integer.parseInt(input[j-1]);
        if(map[i][j] == 1) {
          dp[i][j] = 1;
        }
      }
    }

    int ans = 0;
    for(int i = 1 ; i <= n; i++) {
      for(int j = 1; j <= m; j++) {
        if(map[i][j] == 0) {
          continue;
        } else if(map[i][j] == 1) {
            if(dp[i-1][j] != 0 && dp[i][j-1] != 0 && dp[i-1][j-1] != 0) {
              if(dp[i-1][j] != 1 && dp[i][j-1] != 1 && dp[i-1][j-1] != 1) {
                int min = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                dp[i][j] = (int)Math.pow(Math.sqrt(min) + 1, 2);
              } else {
                dp[i][j] = 4;
              }
            }
            ans = Math.max(ans, dp[i][j]);

        }
      }
    }

    bw.write(ans + "\n");

    br.close();
    bw.close();
  }
}