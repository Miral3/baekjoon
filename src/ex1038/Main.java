package ex1038;

/*
문제 이름: 감소하는 수
알고리즘: 브루트포스 알고리즘, 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static final int MAX = 1022;
    static int n;
    static int idx = 10;
    static int[] out;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        if(n < 10) {
            System.out.print(n);
            return;
        }
        int size = 2;
        while (true) {
            out = new int[size];
            backTracking(0, size);
            size++;

            if (idx > MAX) {
                System.out.println(-1);
                break;
            }
        }
        br.close();
        bw.close();
    }

    public static void backTracking(int depth, int size) {
        if (depth == size) {
            if (idx == n) {
                for (Integer v : out) {
                    System.out.print(v);
                }
                System.out.println();
                System.exit(0);
            }
            idx++;
            return;
        }

        for (int i = 0; i < 10; i++) {

            if (depth == 0 && i == 0) {
                continue;
            }
            if (depth > 0 && out[depth - 1] <= i) {
                continue;
            }
            out[depth] = i;
            backTracking(depth + 1, size);

        }
    }
}
