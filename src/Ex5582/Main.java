package Ex5582;

/*
문제 이름 : 공통 부분 문자열
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

    String firstStr = br.readLine();
    int firstLen = firstStr.length()+1;
    String secondStr = br.readLine();
    int secondLen = secondStr.length()+1;
    int[][] dp = new int[secondLen][firstLen];

    int max = 0;
    for(int i = 1; i < secondLen; i++) {
      char target = secondStr.charAt(i-1);
      for(int j = 1; j < firstLen; j++) {
        char compare = firstStr.charAt(j-1);
        if(target == compare) {
          dp[i][j] = dp[i-1][j-1] +1;
          if(max < dp[i][j]) {
            max = dp[i][j];
          }
        }
      }
    }

    System.out.println(max);
    br.close();
    bw.close();
  }
}

