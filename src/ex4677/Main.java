package ex4677;

/*
문제 이름: Oil Deposits
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
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n;
    static int m;
    static String[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            if (n == 0 && m == 0) {
                break;
            }
            map = new String[n][m];
            isVisited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                input = br.readLine().split("");
                for (int j = 0; j < m; j++) {
                    map[i][j] = input[j];
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!isVisited[i][j] && map[i][j].equals("@")) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }

    public static void bfs(int sy, int sx) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(sy, sx));
        isVisited[sy][sx] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if (isVisited[ny][nx] || map[ny][nx].equals("*")) {
                    continue;
                }

                que.add(new Node(ny, nx));
                isVisited[ny][nx] = true;
            }
        }
    }
}
