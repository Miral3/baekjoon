package Ex2954;

/*
문제 이름 : 창영이의 일기장
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

    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    String[] input = br.readLine().split(" ");
    int size = input.length;


    for(int i = 0; i < size; i++) {
      String str = input[i];
      int len = input[i].length();
      String result = "";

      for(int j = 0; j < len; j++) {
        result += str.charAt(j);
        for(int k = 0; k < 5; k++) {
          if(j < len -2 && str.charAt(j) == vowels[k]) {
            j += 2;
          }
        }
      }

      bw.write(result + " ");
    }

    br.close();
    bw.close();
  }
}