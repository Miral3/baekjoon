package ex2594;

/*
문제 이름: 놀이공원
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] schedules = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = transfrom(input[0]) - 10;
            int end = transfrom(input[1]) + 10;

            schedules[i][0] = start;
            schedules[i][1] = end;
        }

        schedules[n][0] = 1320; // 오후 10시
        schedules[n][1] = Integer.MAX_VALUE;

        Arrays.sort(schedules, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int last = 600; // 오전 10시
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, schedules[i][0] - last);
            last = Math.max(last, schedules[i][1]);
        }

        bw.write(max + "\n");
        br.close();
        bw.close();
    }

    public static int transfrom(String time) {
        int hour = Integer.parseInt(time) / 100;
        int minute = Integer.parseInt(time) % 100;
        return (hour * 60) + minute;
    }
}
