package Ex1264;

/*
문제 이름 : 모음의 개수
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

    String input;
    while(!(input = br.readLine()).equals("#")) {
      int cnt = 0;
      input = input.toLowerCase();
      for(int i = 0; i < input.length(); i++) {
        for(int j = 0; j < 5; j++) {
          if(input.charAt(i) == vowels[j]) {
            cnt++;
          }
        }
      }
      bw.write(cnt + "\n");
    }

    br.close();
    bw.close();
  }
}