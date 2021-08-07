package ex2217;

/*
문제 이름: 로프
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
        Integer[] weight = new Integer[n];
        int max = 0;

        for(int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weight, Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            int maxWeight = weight[i] * (i + 1);
            max = Math.max(max, maxWeight);
        }

        System.out.println(max);

        br.close();
        bw.close();
    }
}
