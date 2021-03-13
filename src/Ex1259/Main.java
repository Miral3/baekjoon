package Ex1259;

/*
문제 이름 : 팰린드롬수
알고리즘 : 구현, 문자열
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

    while(true) {
      int input = Integer.parseInt(br.readLine());
      String str = Integer.toString(input);
      boolean isPalindrome = false;

      if(input == 0) {
        break;
      }

      if(str.length() == 1) {
        bw.write("yes" + "\n");
        continue;
      }

      for(int i = 0; i < str.length()/2; i++) {
        if(str.charAt(i) != str.charAt(str.length()-1-i)) {
          bw.write("no" + "\n");
          isPalindrome = false;
          break;
        } else {
          isPalindrome = true;
        }
      }

      if(isPalindrome) {
        bw.write("yes" + "\n");
      }
    }

    br.close();
    bw.close();
  }
}
