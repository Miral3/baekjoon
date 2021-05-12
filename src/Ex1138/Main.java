package Ex1138;

/*
문제 이름 : 한 줄로 서기
알고리즘 : 구현
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
    int[] line = new int[N+1];
    String[] input = br.readLine().split(" ");

    for(int i = 1; i <= N; i++) {
      line[i] = Integer.parseInt(input[i-1]);
    }

    int[] answer = new int[N+1];

    for(int i = 1; i <= N; i++) {
      if(i == 1) {
        answer[line[i] + 1] = i;
      } else {
        int cnt = 0;
        for(int j = 1; j <= N; j++) {
          if(answer[j] != 0) {
            continue;
          } else {
            if (cnt == line[i]) {
              answer[j] = i;
              break;
            }
            cnt++;
          }
        }
      }
    }

    for(int i = 1; i <= N; i++) {
      bw.write(answer[i] + " ");
    }

    br.close();
    bw.close();
  }
}