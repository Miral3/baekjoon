package ex14620;

/*
문제 이름: 꽃길
알고리즘: 브루트포스, 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int result = 3001;
    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        backTracking(0, 0);

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static void backTracking(int depth, int sum) {
        if (depth == 3) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
               if(isVisited[i][j] || isVisited[i - 1][j] || isVisited[i + 1][j] ||
                   isVisited[i][j - 1] || isVisited[i][j + 1]) {
                   continue;
               }

               for (int k = 0; k < 5; k++) {
                   int y = i + dy[k];
                   int x = j + dx[k];
                   isVisited[y][x] = true;
                   sum += map[y][x];
               }

               backTracking(depth + 1, sum);

               for (int k = 0; k < 5; k++) {
                   int y = i + dy[k];
                   int x = j + dx[k];
                   isVisited[y][x] = false;
                   sum -= map[y][x];
               }
            }
        }
    }
}
