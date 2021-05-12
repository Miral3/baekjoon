package Ex1244;

/*
문제 이름 : 스위치 켜고 끄기
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
    int[] switches = new int[N+1];
    String[] state = br.readLine().split(" ");
    for(int i = 1; i <= N; i++) {
      switches[i] = Integer.parseInt(state[i-1]);
    }

    int testCase = Integer.parseInt(br.readLine());

    for(int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      int gender = Integer.parseInt(input[0]);
      int num = Integer.parseInt(input[1]);
      int idx = 0;

      if(gender == 1) {
        idx = 1;
        while(num * idx <= N) {
          if(switches[num * idx] == 1) {
            switches[num * idx] = 0;
          } else {
            switches[num * idx] = 1;
          }
          idx++;
        }
      } else if(gender == 2) {
          idx = 0;
          while(num - idx > 0 && num + idx <= N) {
            if (switches[num - idx] != switches[num + idx]) {
              break;
            } else {
              if(switches[num-idx] == 0) {
                switches[num-idx] = 1;
                switches[num+idx] = 1;
              } else {
                switches[num-idx] = 0;
                switches[num+idx] = 0;
              }
            }
            idx++;
          }
      }
    }

    for(int i = 1; i <= N; i++) {
      bw.write(switches[i] + " ");
      if(i % 20 == 0) {
        bw.write("\n");
      }
    }
    br.close();
    bw.close();
  }
}

