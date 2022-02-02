package ex18404;

/*
문제 이름: 현명한 나이트
알고리즘: bfs
자료구조: 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y;
    int x;
    int cnt;

    public Node(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] isVistied;
    static int knightY;
    static int knightX;
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n + 1][n + 1];
        isVistied = new boolean[n + 1][n + 1];

        input =  br.readLine().split(" ");
        knightY = Integer.parseInt(input[0]);
        knightX = Integer.parseInt(input[1]);

        int[][] knights = new int[m][2];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);

            knights[i][0] = y;
            knights[i][1] = x;
            map[y][x] = 1;
        }

        bfs();

        for (int i = 0; i < m; i++) {
            int y = knights[i][0];
            int x = knights[i][1];

            bw.write(map[y][x] + " ");
        }
        br.close();
        bw.close();
    }
    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(knightY, knightX, 0));
        isVistied[knightY][knightX] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;

            if (map[y][x] == 1) {
                map[y][x] = cnt;
            }
            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 1 || nx < 1 || ny > n || nx > n) {
                    continue;
                }
                if (isVistied[ny][nx]) {
                    continue;
                }

                isVistied[ny][nx] = true;
                que.add(new Node(ny, nx, cnt + 1));
            }
        }


    }
}
