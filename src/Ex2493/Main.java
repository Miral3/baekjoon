package Ex2493;

/*
문제 이름 : 탑
알고리즘 : 스택
자료구조 : 스택
 */

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    Stack<Integer> top = new Stack<>();
    Stack<Integer> index = new Stack<>();

    for(int i = 1; i <= N; i++) {
      int num = Integer.parseInt(st.nextToken());

      while(!top.isEmpty()) {
        if(num <= top.peek()) {
          bw.write(index.peek() + " ");
          break;
        }
        top.pop();
        index.pop();
      }
      if(top.empty()) {
        bw.write("0 ");
      }
      top.add(num);
      index.add(i);
    }

    br.close();
    bw.close();
  }
}

