package Ex11576;

/*
문제 이름 : Base Conversion
알고리즘 : 구현
자료구조 : 배열, 스택
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

    String[] ipnut1 = br.readLine().split(" ");
    int A = Integer.parseInt(ipnut1[0]);
    int B = Integer.parseInt(ipnut1[1]);

    int m = Integer.parseInt(br.readLine());
    String[] input2 = br.readLine().split(" ");
    int sum = 0;
    for(int i = 0; i < m; i++) {
      sum += Integer.parseInt(input2[i]) * Math.pow(A, (m-(1 + i)));
    }

    Stack<Integer> stack = new Stack<>();
    while(true) {
      int remainder = sum % B;
      sum = sum / B;
      stack.add(remainder);

      if(sum < B) {
        stack.add(sum);
        break;
      }
    }

    while(!stack.isEmpty()) {
      bw.write(stack.pop() + " ");
    }

    br.close();
    bw.close();
  }
}