package ex14235;

/*
문제 이름: 크리스마스 선물
알고리즘: 우선순위 큐
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            if (a[0].equals("0")) {
                if (pq.isEmpty()) {
                    bw.write("-1\n");
                    continue;
                }
                bw.write(pq.poll() + "\n");
            } else {
                int m = Integer.parseInt(a[0]);
                for (int j = 1; j <= m; j++) {
                    pq.add(Integer.parseInt(a[j]));
                }
            }

        }

        br.close();
        bw.close();
    }
}
