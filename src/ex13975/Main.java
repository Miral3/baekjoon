package ex13975;

/*
문제 이름: 파일 합치기 3
알고리즘: 그리디, 우선순위 큐
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());


            String[] input = br.readLine().split(" ");
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(String str : input) {
                pq.add(Long.parseLong(str));
            }

            long result = 0;
            while (pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                result += sum;
                pq.add(sum);
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
