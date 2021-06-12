package Ex1431;

/*
문제 이름 : 시리얼 번호
알고리즘 : 문자열, 정렬
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    String[] arr = new String[testCase];

    for(int i = 0; i < testCase; i++) {
      String input = br.readLine();
      arr[i] = input;
    }

    Arrays.sort(arr, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if(o1.length() < o2.length()) {
          return -1;
        }
        else if(o1.length() > o2.length()) {
          return 1;
        }
        else {
          if(add(o1) == add(o2)) {
            return o1.compareTo(o2);
          }
          else {
            return Integer.compare(add(o1), add(o2));
          }
        }
      }
    });

    for(int i = 0; i < testCase; i++) {
      bw.write(arr[i] + "\n");
    }

    br.close();
    bw.close();
  }

  public static int add(String str) {
    int sum = 0;
    for(int i = 0; i < str.length(); i ++) {
      char c = str.charAt(i);
      if(c >= '0' && c <= '9') {
        sum += c - '0';
      }
    }
    return sum;
  }
}