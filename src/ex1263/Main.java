package ex1263;

/*
문제 이름: 시간 관리
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] work = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            work[i][0] = t;
            work[i][1] = s;
        }

        Arrays.sort(work, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int start = work[0][1] - work[0][0];
        int curTime = work[0][1];
        if (start < 0) {
            start = -1;
        } else {
            for (int i = 1; i < n; i++) {
                if (curTime + work[i][0] <= work[i][1]) {
                    curTime += work[i][0];
                } else {
                    start -= curTime + work[i][0] - work[i][1];
                    curTime -= curTime + work[i][0] - work[i][1];
                    if (start < 0) {
                        start = -1;
                        break;
                    } else {
                        curTime += work[i][0];
                    }
                }
            }
        }

        bw.write(start + "\n");
        br.close();
        bw.close();
    }
}
