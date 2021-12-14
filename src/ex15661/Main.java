package ex15661;

/*
문제 이름: 링크와 스타트
알고리즘: 브루트포스 알고리즘
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i = 1; i < n; i++) {
            getMinScore(0, i, 1);
        }

        bw.write(min + "\n");
        br.close();
        bw.close();
    }

    public static void getMinScore(int depth, int size, int idx) {
        if (depth == size) {
            int result = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i == j) {
                        continue;
                    }
                    if(isVisited[i] && isVisited[j]) {
                        result += map[i][j];
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i == j) {
                        continue;
                    }
                    if(!isVisited[i] && !isVisited[j]) {
                        result -= map[i][j];
                    }
                }
            }

            if(result < 0) {
                result *= -1;
            }

            min = Math.min(min, result);
            return;
        }

        for (int i = idx; i <= n; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                getMinScore(depth + 1, size, i);
                isVisited[i] = false;
            }
        }
    }
}
