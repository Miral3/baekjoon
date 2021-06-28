package Ex1476;

/*
문제 이름 : 날짜 계산
알고리즘 : 수학
자료구조 :
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

    String[] input = br.readLine().split(" ");
    int E = Integer.parseInt(input[0]);
    int S = Integer.parseInt(input[1]);
    int M = Integer.parseInt(input[2]);

    for(int i = 1; i < 7981; i++) {
      int A = i % 15;
      int B = i % 28;
      int C = i % 19;

      if(A == 0) {
        A = 15;
      }
      if(B == 0) {
        B = 28;
      }
      if(C == 0) {
        C = 19;
      }

      if(A == E && B == S && C == M) {
        System.out.println(i);
        return;
      }
    }

    br.close();
    bw.close();
  }
}


