package Ex1475;

/*
문제 이름 : 방 번호
알고리즘 : 구현
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

    int N = Integer.parseInt(br.readLine());
    int[] num = new int[10];
    String trans = Integer.toString(N);
    int len = trans.length();

    for(int i = 0; i < len; i++) {
      int target = trans.charAt(i) - '0';

      if(target == 6) {
        if(num[6] > num[9]) {
          num[9]++;
        } else {
          num[target]++;
        }
      } else if(target == 9) {
        if(num[9] > num[6]) {
          num[6]++;
        } else {
          num[target]++;
        }
      } else {
        num[target]++;
      }
    }

    int max = 0;
    for(int i = 0; i < 10; i++) {
      if(num[i] > max) {
        max = num[i];
      }
    }

    bw.write(max + "\n");

    br.close();
    bw.close();
  }
}

