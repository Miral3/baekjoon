package ex10799;

/*
문제 이름: 쇠막대기
알고리즘: 스택
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

class Node {
    String bracket;
    int cnt;

    public Node(String bracket, int cnt) {
        this.bracket = bracket;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        Stack<Node> stack = new Stack<>();

        int laserCnt = 0;
        int result = 0;
        for(int i = 0; i < input.length; i++) {
            String str = input[i];
            if(stack.isEmpty()) {
                laserCnt = 0;
            }

            if(str.equals("(")) {
                stack.add(new Node(str, laserCnt));
            }
            else {
                Node cur = stack.pop();
                int cnt = cur.cnt;

                if(laserCnt == cnt) {
                    laserCnt++;
                    continue;
                }

                result += laserCnt - cnt + 1;
            }
        }

        System.out.println(result);

        br.close();
        bw.close();
    }
}
