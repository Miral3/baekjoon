package ex2234;

/*
문제 이름: 성곽
알고리즘: 그래프 탐색(bfs), 비트마스킹
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
    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {0 ,-1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int roomCnt = 0;
    static int maxSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!isVisited[i][j]) {
                    bfs(i, j);
                    roomCnt++;
                }
            }
        }
        bw.write(roomCnt + "\n" + maxSize + "\n");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if ((map[i][j] & (1 << k)) != 0) {
                        isVisited = new boolean[n][m];
                        map[i][j] = map[i][j] ^ (1 << k);
                        bfs(i, j);
                        map[i][j] = map[i][j] ^ (1 << k);
                    }
                }
            }
        }
        bw.write(maxSize + "\n");

        br.close();
        bw.close();
    }
    public static void bfs(int startY, int startX) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX));
        isVisited[startY][startX] = true;

        int cnt = 1;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if ((map[y][x] & (1 << i)) == 0) {
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if (isVisited[ny][nx]) {
                        continue;
                    }

                    que.add(new Node(ny, nx));
                    isVisited[ny][nx] = true;
                    cnt++;
                }
            }
        }

        maxSize = Math.max(cnt, maxSize);
    }
}
