package ex2166;

/*
문제 이름: 다각형의 면적
알고리즘: 기하학
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            x[i] = Integer.parseInt(input[0]);
            y[i] = Integer.parseInt(input[1]);
        }
        x[n] = x[0];
        y[n] = y[0];

        long sumA = 0;
        long sumB = 0;
        for(int i = 0; i < n; i++) {
            sumA += x[i] * y[i + 1];
            sumB += x[i + 1] * y[i];
        }

        String answer = String.format("%.1f", (Math.abs(sumA - sumB) / 2.0));
        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}
