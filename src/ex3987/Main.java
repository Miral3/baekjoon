package ex3987;

/*
문제 이름: 보이저 1호
알고리즘: 구현, 시뮬레이션
자료구조: 배열
*/

import java.io.*;

public class Main {
    static char[][] arr;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[] direction = {'U', 'R', 'D', 'L'};
    static boolean isCycle = false;
    static int n;
    static int m;
    static int ansCnt = 0;
    static int ansDir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] input2 = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = input2[j - 1];
            }
        }

        input = br.readLine().split(" ");
        int pr = Integer.parseInt(input[0]);
        int pc = Integer.parseInt(input[1]);

        for (int i = 0; i < 4; i++) {
            if (!isCycle) {
                sendSig(pr, pc, i);
            }
        }

        bw.write(direction[ansDir] + "\n");
        if (isCycle) {
            bw.write("Voyager\n");
        } else {
            bw.write(ansCnt + "\n");
        }
        br.close();
        bw.close();
    }
    public static void sendSig(int startY, int startX, int startDir) {
        int y = startY;
        int x = startX;
        int dir = startDir;
        int cnt = 1;

        while (true) {
            y = y + dy[dir];
            x = x + dx[dir];

            if (y <= 0 || x <= 0 || y > n || x > m || arr[y][x] == 'C') {
                if (ansCnt < cnt) {
                    ansCnt = cnt;
                    ansDir = startDir;
                }
                return;
            }

            if (y == startY && x == startX && dir == startDir) {
                ansDir = startDir;
                isCycle = true;
                return;
            }

            if (arr[y][x] == '/') {
                dir = 1 ^ dir;
            } else if (arr[y][x] == '\\') {
                dir = 3 - dir;
            }

            cnt++;
        }
    }
}
