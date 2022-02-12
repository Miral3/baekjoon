package ex1986;

/*
문제 이름: 체스
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[] knightDirY = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] knightDirX = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] queenDirY = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] queenDirX = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n + 1][m + 1];
        Queue<Node> queen = new LinkedList<>();
        Queue<Node> knight = new LinkedList<>();

        // 퀸, 나이트, 폰의 위치를 입력받아 큐에 저장
        for (int i = 0; i < 3; i++) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            for (int j = 0; j < num; j++) {
                int y = Integer.parseInt(input[2 * j + 1]);
                int x = Integer.parseInt(input[2 * j + 2]);

                if (i == 0) {
                    queen.add(new Node(y, x));
                } else if (i == 1) {
                    knight.add(new Node(y, x));
                } else if (i == 2) { // 폰의 위치는 체스판에 바로 기록
                    map[y][x] = 2;
                }
            }
        }

        // 나이트는 움직이는데 제약이 없으므로 먼저 움직인다
        while (!knight.isEmpty()) {
            Node cur = knight.poll();
            int y = cur.y;
            int x = cur.x;
            map[y][x] = 2;

            for (int i = 0; i < 8; i++) {
                int ny = y + knightDirY[i];
                int nx = x + knightDirX[i];

                if (ny < 1 || nx < 1 || ny > n || nx > m) {
                    continue;
                }
                if (map[ny][nx] != 0) {
                    continue;
                }

                map[ny][nx] = 1;
            }
        }

        int size = Math.max(n, m);
        while (!queen.isEmpty()) {
            Node cur = queen.poll();
            int y = cur.y;
            int x = cur.x;
            map[y][x] = 2;

            for (int i = 0; i < 8; i++) {
                for (int j = 1; j <= size; j++) {
                    int ny = y + (j * queenDirY[i]);
                    int nx = x + (j * queenDirX[i]);

                    if (ny < 1 || nx < 1 || ny > n || nx > m) {
                        break;
                    }
                    if (map[ny][nx] == 2) {
                        break;
                    }

                    map[ny][nx] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) {
                    ans++;
                }
            }
        }

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}
