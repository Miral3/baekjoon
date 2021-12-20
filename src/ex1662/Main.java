package ex1662;

/*
문제 이름: 압축
알고리즘: 스택, 문자열
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        Stack<Character> cStack = new Stack<>();
        Stack<Integer> iStack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            if(input[i] != ')') {
                cStack.add(input[i]);
            } else {
                int q = 0;
                while(cStack.peek() != '(') {
                    if(cStack.pop() == 'N') {
                        q += iStack.pop();
                    } else {
                        q++;
                    }
                }
                cStack.pop();

                int num = 0;
                int k = cStack.pop() - '0';
                num = q * k;
                cStack.add('N');
                iStack.add(num);
            }
        }

        int result = 0;
        while (!cStack.isEmpty()) {
            if(cStack.pop() == 'N') {
                result += iStack.pop();
            } else {
                result++;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
