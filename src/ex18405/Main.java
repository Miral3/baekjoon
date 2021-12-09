package ex18405;

/*
문제 이름: 경쟁적 전염
알고리즘: 구현, bfs
자료구조: 배열, 우선순위 큐
*/

import java.io.*;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int y;
    int x;
    int k;

    public Node(int y, int x, int k) {
        this.y = y;
        this.x = x;
        this.k = k;
    }

    @Override
    public int compareTo(Node o) {
        return k - o.k;
    }
}

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static PriorityQueue<Node> que = new PriorityQueue<>();
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        map = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]) - 1;
        int x = Integer.parseInt(input[2]) - 1;

        for (int t = 0; t < s; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isVisited[i][j] && map[i][j] != 0) {
                        que.add(new Node(i, j, map[i][j]));
                    }
                }
            }
            bfs();
        }

        bw.write(map[y][x] + "\n");
        br.close();
        bw.close();
    }

    public static void bfs() {
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;
            int k = cur.k;
            isVisited[y][x] = true;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if (map[ny][nx] != 0) {
                    continue;
                }

                map[ny][nx] = k;
            }
        }
    }
}
