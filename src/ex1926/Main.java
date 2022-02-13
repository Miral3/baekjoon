package ex1926;

/*
문제 이름: 그림
알고리즘: bfs
자료구조: 배열, 큐
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
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] isVisited;
    static int max = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        bw.write(cnt + "\n" + max + "\n");
        br.close();
        bw.close();
    }

    public static void bfs(int startY, int startX) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX));
        isVisited[startY][startX] = true;

        int cnt = 1;
        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if (isVisited[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }

                cnt++;
                que.add(new Node(ny, nx));
                isVisited[ny][nx] = true;
            }
        }

        max = Math.max(max, cnt);
    }
}
