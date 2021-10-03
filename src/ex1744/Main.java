package ex1744;

/*
문제 이름: 수 묶기
알고리즘: 그리디, 정렬
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long result = 0;
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num <= 0) {
                negative.add(num);
            } else {
                positive.add(num);
            }
        }

        while(!negative.isEmpty()) {
            int cur = negative.poll();
            if(negative.isEmpty()) {
                result += cur;
            } else {
                result += (cur * negative.poll());
            }
        }

        while(!positive.isEmpty()) {
            int cur = positive.poll();
            if(positive.isEmpty()) {
                result += cur;
            } else  {
                int nxt = positive.peek();
                if(cur == 1 || nxt == 1) {
                    result += cur;
                    continue;
                } else {
                    result += (cur * positive.poll());
                }
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
