package Ex2845;

/*
문제 이름 : 파티가 끝나고 난 뒤
알고리즘 : 구현
자료구조 : 정수
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

    String[] input1 = br.readLine().split(" ");
    int L = Integer.parseInt(input1[0]);
    int P = Integer.parseInt(input1[1]);
    int num = L * P;

    String[] input2 = br.readLine().split(" ");
    for(int i = 0; i < 5; i++) {
      bw.write(Integer.parseInt(input2[i]) - num + " ");
    }
    br.close();
    bw.close();
  }
}