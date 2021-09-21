package ex2812;

/*
문제 이름: 크게 만들기
알고리즘: 그리디
자료구조: 스택, 문자열
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String num = br.readLine();
        Stack<Character> stack = new Stack<>();
        stack.add(num.charAt(0));

        int idx = 0;
        for(int i = 1; i < n; i++) {
            int now = num.charAt(i) - '0';

            while (!stack.isEmpty()) {
                if (idx < k && now > stack.peek() - '0') {
                    stack.pop();
                    idx++;
                } else {
                    break;
                }
            }
            stack.add((char)(now + '0'));
        }

        if(idx < k) {
            for(int i = 0; i < k - idx; i++) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String answer = sb.reverse().toString();
        bw.write(answer + "\n");


        br.close();
        bw.close();
    }
}
