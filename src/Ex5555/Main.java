package Ex5555;

/*
문제 이름 : 반지
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

    String target = br.readLine();
    int N = Integer.parseInt(br.readLine());
    int result = 0;
    for(int i = 0; i < N; i++) {
      String input = br.readLine();
      String str = input + input;
      if(str.contains(target)) {
        result++;
      }
    }

    System.out.println(result);

    br.close();
    bw.close();
  }
}