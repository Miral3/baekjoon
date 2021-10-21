package ex1057;

/*
문제 이름: 토너먼트
알고리즘: 브루트포스
자료구조: 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            que.add(i);
        }

        int result = 1;
        while(true) {
            boolean isFind = false;
            while(!que.isEmpty()) {
                int x = que.poll();
                int y = 0;
                if(que.isEmpty()) {
                    sb.append(x).append(' ');
                } else {
                    y = que.poll();
                }
                if(x == a && y == b) {
                    isFind = true;
                    break;
                }
                if(y == a || y == b) {
                    sb.append(y).append(' ');
                } else {
                    sb.append(x).append(' ');
                }
            }
            if(isFind) {
                break;
            }

            String[] winner = sb.toString().split(" ");
            sb.setLength(0);
            for(int i = 0; i < winner.length; i++) {
                que.add(Integer.parseInt(winner[i]));
            }
            result++;
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
