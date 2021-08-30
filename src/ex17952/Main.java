package ex17952;

/*
문제 이름: 과제는 끝나지 않아!
알고리즘: 구현, 스택
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

class Node {
    int score, time;

    public Node(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int score = 0;
            int time = 0;

            if(m == 0) {
                if(stack.isEmpty()) {
                    continue;
                }

                Node cur = stack.pop();
                if(cur.time - 1 == 0) {
                    result += cur.score;
                } else {
                    stack.add(new Node(cur.score, cur.time - 1));
                }
            } else {
                score = Integer.parseInt(input[1]);
                time = Integer.parseInt(input[2]);

                if(time == 1) {
                    result += score;
                } else {
                    stack.add(new Node(score, time - 1));
                }
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}
