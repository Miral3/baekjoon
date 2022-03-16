package ex16948;

/*
문제 이름: 데스 나이트
알고리즘: bfs
자료구조: 큐, 배열
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
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];
        String[] input = br.readLine().split(" ");
        int r1 = Integer.parseInt(input[0]);
        int c1 = Integer.parseInt(input[1]);
        int r2 = Integer.parseInt(input[2]);
        int c2 = Integer.parseInt(input[3]);

        int ans = bfs(r1, c1, r2, c2);

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }

    public static int bfs(int r1, int c1, int r2, int c2) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(r1, c1, 0));
        isVisited[r1][c1] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;

            if (y == r2 && x == c2) {
                return cnt;
            }

            for (int i = 0; i < 6; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if (isVisited[ny][nx]) {
                    continue;
                }

                isVisited[ny][nx] = true;
                que.add(new Node(ny, nx, cnt + 1));
            }

        }

        return -1;
    }
}
