package ex4889;

/*
문제 이름: 안정적인 문자열
알고리즘: 문자열, 스택
자료구조: 문자열, 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;
        while(true) {
            String input = br.readLine();

            if(input.contains("-")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if(ch == '}') {
                    if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.add(ch);
                    }
                } else {
                    stack.add(ch);
                }
            }

            int cnt = 0;
            while(!stack.isEmpty()) {
                char a = stack.pop();
                char b = stack.pop();

                if(a == b) {
                    cnt++;
                } else {
                    cnt += 2;
                }
            }

            bw.write(idx + ". " + cnt + "\n");

            idx++;
        }

        br.close();
        bw.close();
    }
}
