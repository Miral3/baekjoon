package ex5212;

/*
문제 이름: 지구 온난화
알고리즘: 구현, 시뮬레이션
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        char[][] map = new char[r][c];
        boolean[][] isVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] info = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = info[j];
            }
        }

        int yMin = 11;
        int yMax = -1;
        int xMin = 11;
        int xMax = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 'X') {
                    int cnt = 0;
                    isVisited[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                            cnt++;
                            continue;
                        }
                        if (isVisited[ny][nx]) {
                            continue;
                        }
                        if (map[ny][nx] == '.') {
                            cnt++;
                        }
                    }

                    if (cnt >= 3) {
                        map[i][j] = '.';
                    } else {
                        yMin = Math.min(yMin, i);
                        yMax = Math.max(yMax, i);
                        xMin = Math.min(xMin, j);
                        xMax = Math.max(xMax, j);
                    }
                }
            }
        }

        for (int i = yMin; i <= yMax; i++) {
            for (int j = xMin; j <= xMax; j++) {
                bw.write(map[i][j] + "");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
