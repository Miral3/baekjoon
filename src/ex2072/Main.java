package ex2072;

/*
문제 이름: 오목
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = -1;
            }
        }

        int ans = -1;
        int n = Integer.parseInt(br.readLine());
        // 왼, 오, 위, 아래, 좌상, 우하, 우상, 좌하
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
        for (int i = 1; i <= n; i++) {
            int color = i % 2; // 홀(1) : 흑, 짝(0) : 백
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);

            map[y][x] = color;

            int cnt = 1;
            for (int j = 0; j < 8; j++) {
                int idx = 1;
                while (true) {
                    int ny = y + (dy[j] * idx);
                    int nx = x + (dx[j] * idx);

                    if (ny <= 0 || nx <= 0 || ny > 19 || nx > 19) {
                        break;
                    }
                    if (map[ny][nx] != color) {
                        break;
                    }

                    cnt++;
                    idx++;
                }

                if (j % 2 == 1) { // (왼, 오), (위, 아래)... 이런식으로 묶어서 cnt가 5개면 게임끝
                    if (cnt == 5) {
                        ans = i;
                        break;
                    } else {
                        cnt = 1;
                    }
                }
            }

            if (ans != -1) {
                break;
            }
        }

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}
