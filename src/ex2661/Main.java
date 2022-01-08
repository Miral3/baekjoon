package ex2661;

/*
문제 이름: 좋은 수열
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] out;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        out = new int[n + 1];

        backTracking(n, 1);

        br.close();
        bw.close();
    }

    public static void backTracking(int n, int depth) {
        if (depth == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(out[i]);
            }
            System.out.println();
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (i == out[depth - 1]) {
                continue;
            }
            out[depth] = i;
            if (check(depth)) {
                backTracking(n, depth + 1);
            }
        }
    }

    public static boolean check(int size) {
        for (int i = 0; i < size / 2; i++) {
            int cnt = 0;
            for (int j = size; j >= size - i; j--) {
                int k = j - (i + 1);

                if (out[j] == out[k]) {
                    cnt++;
                }
            }
            if (cnt == i + 1) {
                return false;
            }
        }
        return true;
    }
}
