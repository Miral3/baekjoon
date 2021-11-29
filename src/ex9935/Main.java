package ex9935;

/*
문제 이름: 문자열 폭발
알고리즘: 문자열, 스택
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputStr = br.readLine().split("");
        String[] bombStr = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < inputStr.length; i++) {
            stack.add(inputStr[i]);

            if(inputStr[i].equals(bombStr[bombStr.length-1])) {
                if(stack.size() < bombStr.length) {
                    continue;
                }

                boolean isBombStr = true;
                for(int j = 0; j < bombStr.length; j++) {
                    if(!stack.get(stack.size() - 1 - j).equals(bombStr[bombStr.length -1 - j])) {
                        isBombStr = false;
                        break;
                    }
                }

                if(isBombStr) {
                    for(int j = 0; j < bombStr.length; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.size() == 0) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.reverse().toString() + "\n");
        br.close();
        bw.close();
    }
}
