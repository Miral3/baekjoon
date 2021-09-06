package ex17413;

/*
문제 이름: 단어 뒤집기 2
알고리즘: 구현, 문자열
자료구조: 문자열
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean inBracket = false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if(inBracket) {
                if(target == '>') {
                    inBracket = false;
                }
                bw.write(target + "");
            } else {
                if (target == '<') {
                    while(!stack.isEmpty()) {
                        bw.write(stack.pop() + "");
                    }
                    inBracket = true;
                    bw.write(target + "");
                } else if(target == ' ') {
                    while(!stack.isEmpty()) {
                        bw.write(stack.pop() + "");
                    }
                    bw.write(" ");
                } else {
                    stack.add(target);
                }
            }
        }
        while(!stack.isEmpty()) {
            bw.write(stack.pop() + "");
        }

        br.close();
        bw.close();
    }
}
