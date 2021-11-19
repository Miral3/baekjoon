package ex15903;

/*
문제 이름: 카드 합체 놀이
알고리즘: 그리디, 우선순위 큐
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            pq.add(Long.parseLong(input[i]));
        }

        for(int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;

            pq.add(sum);
            pq.add(sum);
        }

        long sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        bw.write(sum + "\n");
        br.close();
        bw.close();
    }
}
