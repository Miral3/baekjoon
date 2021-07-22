package ex1406;

/*
문제 이름: 에디터
알고리즘: 스택
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for(String s : input) {
            left.add(s);
        }

        for(int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "L" :
                    if(!left.isEmpty()) {
                        right.add(left.pop());
                    }
                    break;
                case "D" :
                    if(!right.isEmpty()) {
                        left.add(right.pop());
                    }
                    break;
                case "B" :
                    if(!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "P" :
                    left.add(command[1]);
                    break;
                default:
                    break;
            }
        }

        while(!left.isEmpty()) {
            right.add(left.pop());
        }

        while(!right.isEmpty()) {
            bw.write(right.pop());
        }
        br.close();
        bw.close();
    }
}