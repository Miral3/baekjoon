package ex1600;

/*
문제 이름: 말이 되고픈 원숭이
알고리즘: 그래프탐색
자료구조: 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y, x, cnt, k;

    public Node(int y, int x, int cnt, int k) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.k = k;
    }
}

public class Main {
    static int k, r, c;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] map;
    static boolean[][][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        c = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        map = new int[r][c];
        isVisited = new boolean[k + 1][r][c];

        for(int i = 0; i < r; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();

        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, k));
        isVisited[0][0][0] = true;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;
            int k = cur.k;

            if(y == r-1 && x == c-1) {
                System.out.println(cur.cnt);
                return;
            }

            if(y >= r || x >= c || y < 0 || x < 0) continue;
            if(map[y][x] == 1) continue;
            if(isVisited[k][y][x]) continue;
            isVisited[k][y][x] = true;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                que.add(new Node(ny, nx, cnt + 1, k));
            }

            if(k == 0) continue;
            for(int i = 0; i < 8; i++) {
                int ny = y + hy[i];
                int nx = x + hx[i];

                que.add(new Node(ny, nx, cnt + 1, k-1));
            }
        }

        System.out.println(-1);
        return;
    }
}
