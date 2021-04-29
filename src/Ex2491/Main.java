package Ex2491;

/*
문제 이름 : 수열
알고리즘 : 다이나믹 프로그래밍
자료구조 : 베얄
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
    int max = 0;
    int[] increaseDp = new int[N];
    int[] decreaseDp = new int[N];

    if(N == 1) {
      bw.write("1\n");
    } else {
      Arrays.fill(increaseDp, 1);
      Arrays.fill(decreaseDp, 1);
      for (int i = 1; i < N; i++) {
        int now = Integer.parseInt(input[i]);
        int prev = Integer.parseInt(input[i - 1]);

        if (now >= prev) {
          increaseDp[i] = increaseDp[i - 1] + 1;
          if (increaseDp[i] > max) {
            max = increaseDp[i];
          }
        }
        if (now <= prev) {
          decreaseDp[i] = decreaseDp[i - 1] + 1;
          if (decreaseDp[i] > max) {
            max = decreaseDp[i];
          }
        }
      }

      bw.write(max + "\n");
    }
    br.close();
    bw.close();
  }
}
