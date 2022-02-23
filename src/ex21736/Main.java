package ex21736;

/*
문제 이름: 헌내기는 친구가 필요해
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
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new char[n][m];
        isVisited = new boolean[n][m];

        int startY = 0;
        int startX = 0;
        for (int i = 0; i < n; i++) {
            char[] input2 = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input2[j];
                if(map[i][j] == 'I') {
                    startY = i;
                    startX = j;
                }
            }
        }

        bfs(startY, startX);

        if (answer == 0) {
            bw.write("TT\n");
        } else {
            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }

    public static void bfs(int startY, int startX) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX));
        isVisited[startY][startX] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            if (map[y][x] == 'P') {
                answer++;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if (isVisited[ny][nx] || map[ny][nx] == 'X') {
                    continue;
                }

                que.add(new Node(ny, nx));
                isVisited[ny][nx] = true;
            }
        }
    }
}
