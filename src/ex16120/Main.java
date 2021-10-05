package ex16120;

/*
문제 이름: PPAP
알고리즘: 그리디, 스택
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack<>();


        for(int i = 0; i < input.length; i++) {
            if(input[i].equals("P")) {
                stack.add("P");
            } else {
                if(i >= input.length - 1 || stack.size() < 2) {
                    System.out.println("NP");
                    return;
                }
                if(!input[i + 1].equals("P")) {
                    System.out.println("NP");
                    return;
                }
                for(int j = 0; j < 2; j++) {
                    if(!stack.pop().equals("P")) {
                        System.out.println("NP");
                        return;
                    }
                }
                stack.add("P");
                i++;
            }
        }

        if(stack.size() == 1 && stack.pop().equals("P")) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }

        br.close();
        bw.close();
    }
}
