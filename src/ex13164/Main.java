package ex13164;

/*
문제 이름: 행복 유치원
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];

        input = br.readLine().split(" ");
        for(int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] sub = new int[n - 1];
        for(int i = 1; i < n; i++) {
            sub[i - 1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(sub);

        int answer = 0;
        for(int i = 0; i < n - k; i++) {
            answer += sub[i];
        }

        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}
