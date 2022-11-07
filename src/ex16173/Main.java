package ex16173;

/*
문제 이름: 점프왕 쩰리 (Small)
알고리즘: bfs
자료구조: 큐, 배열
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
    static String answer;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answer = "Hing";
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        isVisited[0][0] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            if (map[y][x] == -1) {
                answer = "HaruHaru";
                return;
            }
            for (int i = 0; i < 2; i++) {
                int ny = y + dy[i] * map[y][x];
                int nx = x + dx[i] * map[y][x];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if (isVisited[ny][nx]) {
                    continue;
                }

                que.add(new Node(ny, nx));
                isVisited[ny][nx] = true;
            }
        }
    }
}
