package ex1205;

/*
문제 이름: 등수 구하기
알고리즘: 정렬, 구현
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int song = Integer.parseInt(input1[1]);
        int p = Integer.parseInt(input1[2]);

        if(n == 0) {
            System.out.println(1);
            return;
        }

        String[] input2 = br.readLine().split(" ");
        Integer[] score = new Integer[n + 1];
        for(int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(input2[i]);
        }

        score[n] = song;
        Arrays.sort(score, Collections.reverseOrder());

        int rank = 1;
        for(int i = 0; i < n + 1; i++) {
            if(i == p) {
                break;
            }
            if(i > 0 && score[i - 1] > score[i]) {
                rank = i + 1;
            }
            if(score[i] == song) {
                if(i < n) {
                    if(score[i + 1] == song) {
                        continue;
                    }
                }
                System.out.println(rank);
                return;
            }
        }

        System.out.println(-1);

        br.close();
        bw.close();
    }
}
