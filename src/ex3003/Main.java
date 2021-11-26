package ex3003;

/*
문제 이름: 킹, 퀸, 룩, 비숍, 나이트, 폰
알고리즘: 수학, 구현, 사칙연산
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] correct = {1, 1, 2, 2, 2, 8};
        String[] input = br.readLine().split(" ");
        int[] arr = new int[6];
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            sb.append(correct[i] - arr[i]).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
