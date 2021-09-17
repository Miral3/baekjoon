package ex1743;

/*
문제 이름: 음식물 피하기
알고리즘: 그래프 탐색, bfs
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
    static int max = 0;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] ny = {-1, 1, 0, 0};
    static int[] nx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        map = new int[n + 1][m + 1];
        isVisited = new boolean[n + 1][m + 1];
        for(int i = 0; i < k; i++) {
            input = br.readLine().split(" ");

            int y = Integer.parseInt(input[0]);
            int x= Integer.parseInt(input[1]);

            map[y][x] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(!isVisited[i][j] && map[i][j] == 1) {
                    bfs(i ,j);
                }
            }
        }

        bw.write(max + "\n");

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
                int dy = y + ny[i];
                int dx = x + nx[i];

                if(dy <= 0 || dx <= 0 || dy > n || dx > m) {
                    continue;
                }
                if(map[dy][dx] == 0 || isVisited[dy][dx]) {
                    continue;
                }

                que.add(new Node(dy, dx));
                isVisited[dy][dx] = true;
                cnt++;
            }
        }
        max = Math.max(cnt, max);
    }
}
