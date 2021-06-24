package Ex11723;

/*
문제 이름 : 집합
알고리즘 : 비트마스크
자료구조 : 문자열
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

    int S = 0;
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      String command = (input[0]);


      switch (command) {
        case "all":
          S = (1 << 21) - 1;
          break;
        case "empty":
          S = 0;
          break;
          default:
            int x = Integer.parseInt(input[1]);
            switch (command) {
              case "add":
                S |= (1 << x);
                break;
              case "remove":
                S &= ~(1 << x);
                break;
              case "check":
                sb.append((S & (1 << x)) != 0 ? 1 : 0).append('\n');
                break;
              case "toggle":
                S ^= (1 << x);
                break;
            }
      }
    }

    System.out.println(sb);

    br.close();
    bw.close();
  }
}