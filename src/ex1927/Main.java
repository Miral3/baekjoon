package ex1927;

/*
문제 이름: 최소 힙
알고리즘: 자료 구조, 우선순위 큐
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(!pq.isEmpty()) {
                    bw.write(pq.poll() + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else {
                pq.add(input);
            }
        }

        br.close();
        bw.close();
    }
}
