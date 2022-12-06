package ex2852;

/*
문제 이름: NBA 농구
알고리즘: 구현, 문자열
자료구조: 문자열, 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[3];
        int[] result = new int[3];
        int prev = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            String[] time = input[1].split(":");
            int min = Integer.parseInt(time[0]);
            int sec = Integer.parseInt(time[1]);

            if (i != 0) {
                if (score[1] > score[2]) {
                    result[1] += (min * 60 + sec) - prev;
                } else if (score[1] < score[2]) {
                    result[2] += (min * 60 + sec) - prev;
                }
            }
            score[num]++;
            prev = min * 60 + sec;
        }

        int last = 48  * 60;
        if (score[1] > score[2]) {
            result[1] +=  last - prev;
        } else if (score[1] < score[2]) {
            result[2] +=  last - prev;
        }

        for (int i = 1; i <= 2; i++) {
            bw.write(transStringTime(result[i]) + "\n");
        }

        br.close();
        bw.close();
    }

    public static String transStringTime(int time) {
        String min = Integer.toString(time / 60);
        String sec = Integer.toString(time % 60);

        if (min.length() < 2) {
            min = "0" + min;
        }
        if (sec.length() < 2) {
            sec = "0" + sec;
        }

        return min + ":" + sec;
    }
}
