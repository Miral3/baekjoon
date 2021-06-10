package Ex10610;

/*
문제 이름 : 30
알고리즘 : 문자열, 수학
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split("");
    Arrays.sort(input, Collections.reverseOrder());
    int size = input.length;

    if(!input[size-1].equals("0")) {
      System.out.println("-1");
      return;
    }

    int sum = 0;
    for(int i = 0; i < size;i ++) {
      sum += Integer.parseInt(input[i]);
    }

    if(sum%3 != 0) {
      System.out.println("-1");
      return;
    }

    for(int i = 0; i < size; i++) {
      bw.write(input[i] + "");
    }
    br.close();
    bw.close();
  }
}