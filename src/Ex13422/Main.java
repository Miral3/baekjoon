package Ex13422;

/*
문제 이름 : 도둑
알고리즘 : 두 포인터
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

    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      int N = Integer.parseInt(input[0]); // 집의 개수
      int M = Integer.parseInt(input[1]); // 훔칠 연속된 집의 개수
      long K = Integer.parseInt(input[2]); // 자동 방법 장치 작동 최소 수
      long result = 0;

      String[] money = br.readLine().split(" ");
      long[] village = new long[N + M - 1];

      for (int j = 0; j < N + M - 1; j++) {
        if(j < N) {
          village[j] = Integer.parseInt(money[j]);
        } else {
          village[j] = village[j-N];
        }
      }

      long total = 0;
      for(int j = 0; j < M; j++) {
        total += village[j];
      }
      if(total < K) {
        result++;
      }

      if(N == M && total < K) {
        bw.write("1\n");
        continue;
      }
      for(int j = 1; j < N; j++) {
        total -= village[j-1];
        total += village[j+M-1];

        if(total < K) {
          result++;
        }
      }
      bw.write(result+"\n");
    }

    br.close();
    bw.close();
  }
}
