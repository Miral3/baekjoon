package Ex1145;

/*
문제 이름 : 적어도 대부분의 배수
알고리즘 : 브루트포스
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

    String[] input = br.readLine().split(" ");
    int[] arr = new int[5];
    for(int i = 0; i < 5; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int num = 1;
    while(true) {
      int cnt = 0;
      for(int i = 0; i < 5; i++) {
        if(num >= arr[i] && num % arr[i] == 0) {
          cnt++;
        }
      }

      if(cnt >= 3) {
        System.out.println(num);
        break;
      }

      num++;
    }

    br.close();
    bw.close();
  }
}