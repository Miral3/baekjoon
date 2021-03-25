package Ex15829;

/*
문제 이름 : Hashing
알고리즘 : 해싱
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

    int L = Integer.parseInt(br.readLine());
    long hash = 0;
    long temp = 1;
    int M = 1234567891;
    String input = br.readLine();

    for(int i = 0; i < L; i++) {
      int a = (int)input.charAt(i) - 96;
      hash += (a * temp)% M;
      temp *= 31;
      temp %= M;
    }

    bw.write(hash%M + "\n");
    br.close();
    bw.close();
  }
}
