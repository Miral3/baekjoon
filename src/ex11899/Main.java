package ex11899;

/*
문제 이름: 괄호 끼어넣기
알고리즘: 문자열
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(stack.isEmpty()) {
                stack.add(ch);
            } else {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }
        }

        System.out.println(stack.size());

        br.close();
        bw.close();
    }
}
