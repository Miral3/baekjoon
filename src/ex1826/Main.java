package ex1826;

/*
문제 이름: 연료 채우기
알고리즘: 그리디, 정렬, 우선순위 큐
자료구조: 배열, 우선순위 큐
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] gasStation = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            gasStation[i][0] = Integer.parseInt(input[0]);
            gasStation[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(gasStation, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        String[] input2 = br.readLine().split(" ");
        int l = Integer.parseInt(input2[0]);
        int p = Integer.parseInt(input2[1]);

        int i = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(p < l) {
            while(i < n && p >= gasStation[i][0]) {
                pq.add(gasStation[i][1]);
                i++;
            }

            if(pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            p += pq.poll();
            cnt++;
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
