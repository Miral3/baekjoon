package Ex11718;

/*
문제 이름 : 그대로 출려하기
알고리즘 : 문자열
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

    String input;
    while((input = br.readLine()) != null) {
      bw.write(input + "\n");
    }

    br.close();
    bw.close();
  }
}