package ex12845;

/*
문제 이름: 모두의 마블
알고리즘: 그리디 알고리즘, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Integer[] levels = new Integer[n];
        for (int i = 0; i < n; i++) {
            int level = Integer.parseInt(input[i]);
            levels[i] = level;
        }

        Arrays.sort(levels, Collections.reverseOrder());

        int answer = 0;
        for (int i = 1; i < n; i++) {
            answer += levels[0] + levels[i];
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
