package ex2823;

/*
문제 이름: 유턴 싫어
알고리즘: 그래프 이론
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int r;
    static int c;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] input2 = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = input2[j];
            }
        }

        boolean ans = checkMap();
        if (ans) {
            bw.write(0 + "\n");
        } else {
            bw.write(1 + "\n");
        }

        br.close();
        bw.close();
    }

    public static boolean checkMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.') {
                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (canMove(ny, nx)) {
                            ++cnt;
                        }
                    }

                    if (cnt == 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean canMove(int y, int x) {
        if (y == -1 || x == -1 || y == r || x == c || map[y][x] == 'X') {
            return false;
        }

        return true;
    }
}
