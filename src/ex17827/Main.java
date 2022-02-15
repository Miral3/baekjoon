package ex17827;

/*
문제 이름: 달팽이 리스트
알고리즘: 구현, 수학
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        int[] list = new int[n + 1];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());

            if (k >= n) {
                k = k - (v - 1);
                k %= n - (v - 1);
                k += (v-1);
            }

            bw.write(list[k] + "\n");
        }

        br.close();
        bw.close();
    }
}
