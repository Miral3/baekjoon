package ex14716;

/*
문제 이름: 현수막
알고리즘: BFS
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
    static int m;
    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        map = new int[m][n];
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    BFS(i, j);
                    result++;
                }
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static void BFS(int startY, int startX) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX));
        isVisited[startY][startX] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < m && nx < n) {
                    if (!isVisited[ny][nx] && map[ny][nx] == 1) {
                        que.add(new Node(ny, nx));
                        isVisited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
