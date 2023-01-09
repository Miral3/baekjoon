package ex12933;

/*
문제 이름: 오리
알고리즘: 구현
자료구조: 스택, 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        ArrayList<Stack<Character>> list = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            char cur = input[i];
            if (list.isEmpty()) {
                if (cur != 'q') {
                    answer = -1;
                    break;
                }
                Stack<Character> stack = new Stack<>();
                stack.add(cur);
                list.add(stack);
                continue;
            }
            if (!findDuck(cur, list)) {
                answer = -1;
                break;
            }
        }

        if (answer != -1) {
            answer = list.size();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).pop() != 'k') {
                    answer = -1;
                    break;
                }
            }
        }
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static boolean checkPrev (char cur, Stack<Character> stack) {
        char[] arr = {'k', 'q', 'u', 'a', 'c', 'k'};

        for (int i = 1; i < 6; i++) {
            if (cur == arr[i] && stack.peek() == arr[i-1]) {
                stack.add(cur);
                return true;
            }
        }
        return false;
    }
    public static boolean findDuck (char cur, ArrayList<Stack<Character>> list) {
        for (int j = 0; j < list.size(); j++) {
            if (checkPrev(cur, list.get(j))) {
                return true;
            }
        }

        if (cur != 'q') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.add(cur);
        list.add(stack);
        return true;
    }
}
