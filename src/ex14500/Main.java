package ex14500;

/*
문제 이름: 테트로미노
알고리즘: 구현, 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        isVisited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                isVisited[i][j] = true;
                dfs(i, j, 0, 0);
                isVisited[i][j] = false;

                exception(i, j);
            }
        }

        bw.write(max + "\n");

        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, int cnt, int sum) {
        if(cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if(isVisited[ny][nx]) {
                continue;
            }

            isVisited[ny][nx] = true;
            dfs(ny, nx, cnt + 1, sum + map[ny][nx]);
            isVisited[ny][nx] = false;
        }
    }

    public static void exception(int y, int x) {
        int sum = 0;
        if(y >= 0 && x >= 0 && y + 1 < n && x + 2 < m) {
            sum =  map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1];
            max = Math.max(sum, max);
        }
        if(y >= 0 && x >= 0 && y + 2 < n && x + 1 < m) {
            sum =  map[y][x] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 2][x];
            max = Math.max(sum, max);
        }
        if(y - 1 >= 0 && x >= 0 && y < n && x + 2 < m) {
            sum =  map[y - 1][x + 1] + map[y][x] + map[y][x + 1] + map[y][x + 2];
            max = Math.max(sum, max);
        }
        if(y - 1 >= 0 && x >= 0 && y + 1 < n && x + 1 < m) {
            sum =  map[y - 1][x + 1] + map[y][x] + map[y][x + 1] + map[y + 1][x + 1];
            max = Math.max(sum, max);
        }
    }
}
