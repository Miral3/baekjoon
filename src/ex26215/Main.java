package ex26215;

/*
문제 이름: 눈 치우기
알고리즘: 구현, 그리디, 정렬
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
        String[] input = br.readLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(input[i]));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            int second = 0;
            if (!pq.isEmpty()) {
                second = pq.poll();
            }

            if (second == 0) {
                answer += first;
                continue;
            }

            answer += second;
            if (first - second == 0) {
                continue;
            }
            pq.add(first - second);
        }

        if (answer > 1440) {
            answer = -1;
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
