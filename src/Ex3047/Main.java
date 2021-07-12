package Ex3047;

/*
문제 이름 : ABC
알고리즘 : 구현
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input1 = br.readLine().split(" ");
    int[] arr = new int[3];

    for(int i = 0; i < 3; i++) {
      arr[i] = Integer.parseInt(input1[i]);
    }
    Arrays.sort(arr);

    String input2 = br.readLine();
    for(int i = 0; i < 3; i++) {
      int num = input2.charAt(i) - 'A';
      bw.write(arr[num] + " ");
    }

    br.close();
    bw.close();
  }
}