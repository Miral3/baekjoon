package ex23757;

/*
문제 이름: 아이들과 선물 상자
알고리즘: 구현
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(input[i]));
        }

        int answer = 1;
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int wantNum = Integer.parseInt(input[i]);
            int giftNum = pq.poll();
            if (giftNum < 1 || giftNum < wantNum) {
                answer = 0;
                break;
            }
            pq.add(giftNum - wantNum);
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
