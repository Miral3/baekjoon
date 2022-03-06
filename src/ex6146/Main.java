package ex6146;

/*
문제 이름: 신아를 만나러
알고리즘: bfs
자료구조: 배열, 큐
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
    static int answer = 0;
    static int sinahY;
    static int sinahX;
    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        sinahX = Integer.parseInt(input[0]) + 500;
        sinahY = Integer.parseInt(input[1]) + 500;
        n = Integer.parseInt(input[2]);

        map = new int[1001][1001];
        isVisited = new boolean[1001][1001];

        map[sinahY][sinahX] = 2;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) + 500;
            int y = Integer.parseInt(input[1]) + 500;

            map[y][x] = 1;
        }

        bfs();

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(500, 500, 0));
        isVisited[500][500] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;

            if (map[y][x] == 2) {
                answer = cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny > 1000 || nx > 1000) {
                    continue;
                }

                if (isVisited[ny][nx] || map[ny][nx] == 1) {
                    continue;
                }

                isVisited[ny][nx] = true;
                que.add(new Node(ny, nx, cnt + 1));
            }
        }
    }
}
