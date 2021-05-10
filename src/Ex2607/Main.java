package Ex2607;

/*
문제 이름 : 비슷한 단어
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

    int testCase = Integer.parseInt(br.readLine());
    String standard = br.readLine();
    int len = standard.length();
    int[] alphabet = new int[26];
    int result = 0;

    for(int i = 0; i < len; i++) {
      int trans = standard.charAt(i) - 'A';
      alphabet[trans]++;
    }

    for(int i = 0; i < testCase - 1; i++) {
      int[] temp = alphabet.clone();
      String input = br.readLine();
      int cnt = 0;

      for(int j  = 0; j < input.length(); j++) {
        if(temp[input.charAt(j)-'A'] > 0 ) {
          cnt++;
          temp[input.charAt(j)-'A']--;
        }
      }

      if(len - 1 == input.length() && cnt == input.length()) {
        result++;
      } else if(len == input.length()) {
        if(cnt == len || cnt == len-1) {
          result++;
        }
      } else if(len+1 == input.length()) {
        if(cnt == len) {
          result++;
        }
      }
    }

    bw.write(result + "\n");

    br.close();
    bw.close();
  }
}

