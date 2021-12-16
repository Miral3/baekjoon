package ex15684;

/*
문제 이름: 사다리 조작
알고리즘: 구현, 백트래킹, 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int m;
    static int h;
    static int result = Integer.MAX_VALUE;
    static int[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);

        ladder = new int[11][271];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            ladder[b][a] = 1;
        }

        backTracking(1, 0);

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
    public static void backTracking( int depth, int size) {
        if (size > 3) {
            return;
        }

        if (checkLadder()) {
            result = Math.min(result, size);
            return;
        }

        for (int i = depth; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (ladder[j][i] == 1 || ladder[j - 1][i] == 1 ||
                    ladder[j + 1][i] == 1) {
                    continue;
                }

                ladder[j][i] = 1;
                backTracking(i, size + 1);
                ladder[j][i] = 0;
            }
        }
    }

    public static boolean checkLadder() {
        for (int i = 1; i <= n; i++) {
            int cur = i;
            for (int j = 1; j <= h; j++) {
                if (ladder[cur][j] == 1) {
                    cur++;
                } else if(ladder[cur-1][j] == 1) {
                    cur--;
                }
            }

            if(cur != i) {
                return false;
            }
        }
        return true;
    }
}