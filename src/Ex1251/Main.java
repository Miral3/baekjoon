package Ex1251;

/*
문제 이름 : 단어 나누
알고리즘 : 구현기, 브루트포스
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    int size = input.length();
    ArrayList<String> list = new ArrayList<>();
    for(int i = 1; i < size - 2; i++) {
      int j = 1;
      int k = size - (i + j);
      while(j < size - 2 && k >= 1) {
        StringBuffer x = new StringBuffer(input.substring(0, i));
        String X = x.reverse().toString();
        StringBuffer y = new StringBuffer(input.substring(i, i + j));
        String Y = y.reverse().toString();
        StringBuffer z = new StringBuffer(input.substring(i + j, i + j + k));
        String Z = z.reverse().toString();
        String sum = X + Y + Z;
        list.add(sum);

        j++;
        k--;
      }
    }

    Collections.sort(list);

    System.out.println(list.get(0));

    br.close();
    bw.close();
  }
}