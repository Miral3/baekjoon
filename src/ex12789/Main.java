package ex12789;

/*
문제 이름: 도키도키 간식드리미
알고리즘: 스택
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == idx) {
                idx++;
            } else {
                stack.add(arr[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() == idx) {
                stack.pop();
                idx++;
            }
        }

        String answer = stack.isEmpty() ? "Nice" : "Sad";
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
