package Ex1874;

/*
문제 이름 : 스택 수열
알고리즘 : 스택
자료구조 : 스택
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] target = new int[n];
    int targetIdx = 0;
    LinkedList<Character> result = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i < n; i++) {
      target[i] = Integer.parseInt(br.readLine());
    }

    for(int i = 1; i < n + 1; i++) {
      stack.push(i);
      result.add('+');

      while(!stack.isEmpty()) {
        if (stack.peek() != target[targetIdx]) {
          break;
        } else {
          stack.pop();
          result.add('-');

          if(targetIdx < n) {
            targetIdx++;
          }
        }
      }
    }

    if(!stack.isEmpty()) {
      bw.write("NO" + "\n");
    } else {
      while (!result.isEmpty()) {
        bw.write(result.pop() + "\n");
      }
    }

    br.close();
    bw.close();
  }
}
