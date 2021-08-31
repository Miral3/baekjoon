package ex5397;

/*
문제 이름: 키로거
알고리즘: 스택
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split("");
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            for(int j = 0; j < input.length; j++) {
                String cmd = input[j];
                switch (cmd) {
                    case "<" :
                        if(!left.isEmpty()) {
                            right.add(left.pop());
                        }
                        break;
                    case ">" :
                        if(!right.isEmpty()) {
                            left.add(right.pop());
                        }
                        break;
                    case "-" :
                        if(!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    default:
                        left.add(cmd);
                        break;
                }
            }

            StringBuilder result = new StringBuilder();
            while(!left.isEmpty()) {
                right.add(left.pop());
            }
            while(!right.isEmpty()) {
                result.append(right.pop());
            }

            bw.write(result.toString() + "\n");
        }

        br.close();
        bw.close();
    }
}
