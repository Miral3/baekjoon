package ex17298;

/*
문제 이름: 오큰수
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
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            if(stack.isEmpty()) {
                result.add(-1);
                stack.add(arr[i]);
                continue;
            }
            while(true) {
                if(stack.isEmpty()) {
                    result.add(-1);
                    stack.add(arr[i]);
                    break;
                }
                if(stack.peek() <= arr[i]) {
                    stack.pop();
                } else {
                    result.add(stack.peek());
                    stack.add(arr[i]);
                    break;
                }
            }
        }
        while(!result.isEmpty()) {
            bw.write(result.pop() + " ");
        }
        br.close();
        bw.close();
    }
}
