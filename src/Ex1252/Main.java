package Ex1252;

/*
문제 이름 : 이진수 덧셈
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

    String[] input = br.readLine().split(" ");

    String first = input[0];
    String second = input[1];
    int size = 0;
    String longer = "";

    if(first.length() > second.length()) {
      size = second.length();
      longer = "first";
    } else {
      size = first.length();
      longer = "second";
    }

    String result = "";
    int inherit = 0;
    for(int i = 0; i < size; i++) {
      int firstCh = first.charAt(first.length() - (i + 1)) - '0';
      int secondCh = second.charAt(second.length() - (i + 1)) - '0';
      int sum = 0;

      if(inherit + firstCh + secondCh == 3) {
        inherit = 1;
        sum = 1;
      }
      else if(inherit + firstCh + secondCh == 2) {
        inherit = 1;
        sum = 0;
      }
      else if(inherit + firstCh + secondCh == 1) {
        inherit = 0;
        sum = 1;
      }
      else if(inherit + firstCh + secondCh == 0) {
        inherit = 0;
        sum = 0;
      }

      result = Integer.toString(sum) + result;
    }

    if(longer.equals("first")) {
      for(int i = first.length() - second.length() - 1; i >= 0; i--) {
        int ch = first.charAt(i) - '0';
        int sum = 0;

        if(inherit + ch == 2) {
          inherit = 1;
          sum = 0;
        }
        else if(inherit + ch == 1) {
          inherit = 0;
          sum = 1;
        }
        else if(inherit + ch == 0) {
          inherit = 0;
          sum = 0;
        }

        result = Integer.toString(sum) + result;
      }
    } else {
      for(int i = second.length() - first.length() - 1; i >= 0; i--) {
        int ch = second.charAt(i) - '0';
        int sum = 0;

        if(inherit + ch == 2) {
          inherit = 1;
          sum = 0;
        }
        else if(inherit + ch == 1) {
          inherit = 0;
          sum = 1;
        }
        else if(inherit + ch == 0) {
          inherit = 0;
          sum = 0;
        }

        result = Integer.toString(sum) + result;
      }
    }

    if(inherit == 1) {
      result = "1" + result;
    }

    if(result.charAt(0) == '0') {
      while(true) {
        if(result.length() != 1) {
          if(result.charAt(0) == '0') {
            result = result.substring(1);
          }
        } else {
          break;
        }
      }
    }
    System.out.println(result);

    br.close();
    bw.close();
  }
}