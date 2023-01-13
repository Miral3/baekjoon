package ex13901;

/*
문제 이름: 로봇
알고리즘: 구현, 시뮬레이션
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int[][]map = new int[R][C];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            map[y][x] = 1;
        }

        input = br.readLine().split(" ");
        int sr = Integer.parseInt(input[0]);
        int sc = Integer.parseInt(input[1]);
        map[sr][sc] = 1;

        int[] dir = new int[4];
        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(input[i]) - 1;
        }
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while (true) {
            boolean isMoved = false;
            for (int i = 0; i < 4; i++) {
                while (true) {
                    int ny = sr + dy[dir[i]];
                    int nx = sc + dx[dir[i]];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        break;
                    }

                    if (map[ny][nx] == 1) {
                        break;
                    }

                    isMoved = true;
                    map[ny][nx] = 1;
                    sr = ny;
                    sc = nx;
                }
            }

            if (!isMoved) {
                break;
            }
        }

        bw.write(sr + " " + sc + "\n");
        br.close();
        bw.close();
    }
}
