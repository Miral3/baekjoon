package ex1913;

/*
문제 이름: 달팽이
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int num = (int)Math.pow(N, 2);
        int y = 0;
        int x = 0;

        if (N == 1) {
            map[0][0] = 1;
            num--;
        }

        while (num > 0) {
            while (y < N && map[y][x] == 0) {
                map[y][x] = num--;
                y++;
            }
            y--;
            x++;
            while (x < N && map[y][x] == 0) {
                map[y][x] = num--;
                x++;
            }
            y--;
            x--;
            while (y >= 0 && map[y][x] == 0) {
                map[y][x] = num--;
                y--;
            }
            y++;
            x--;
            while (x >= 0 && map[y][x] == 0) {
                map[y][x] = num--;
                x--;
            }
            y++;
            x++;
        }

        int[] position = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == target) {
                    position[0] = i + 1;
                    position[1] = j + 1;
                }
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.write(position[0] + " " + position[1] + "\n");
        br.close();
        bw.close();
    }
}
