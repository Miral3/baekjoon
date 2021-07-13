package Ex17608;

/*
문제 이름 : 막대기
알고리즘 : 구현
자료구조 : 스택
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < N; i++) {
      stack.add(Integer.parseInt(br.readLine()));
    }

    int max = 0;
    int result = 0;
    while(!stack.isEmpty()) {
      int next = stack.pop();
      if(max < next) {
        max = next;
        result++;
      }
    }

    System.out.println(result);

    br.close();
    bw.close();
  }
}