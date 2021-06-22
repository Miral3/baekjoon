package Ex2331;

/*
문제 이름 : 반복수열
알고리즘 : 구현
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int A = Integer.parseInt(input[0]);
    int P = Integer.parseInt(input[1]);

    LinkedList<Integer> list = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    list.add(A);
    while(true) {
      while(A > 0) {
        stack.push(A % 10);
        A = A / 10;
      }

      int sum = 0;
      while(!stack.isEmpty()) {
        sum += Math.pow(stack.pop(), P);
      }

      A = sum;

      if(list.contains(A)) {
        System.out.println(list.indexOf(A));
        break;

      }

      list.add(A);
    }

    br.close();
    bw.close();
  }
}