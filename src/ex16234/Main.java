package ex16234;

/*
문제 이름: 인구 이동
알고리즘: 구현, bfs
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
    static int l;
    static int r;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int result = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        while(true) {
            isVisited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isVisited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if(flag) {
                flag = false;
                result++;
            } else {
                break;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static void bfs(int a, int b) {
        Queue<Node> que = new LinkedList<>();
        Queue<Node> storage = new LinkedList<>();
        que.add(new Node(a, b));
        storage.add(new Node(a, b));
        isVisited[a][b] = true;
        int cnt = 1;
        int sum = map[a][b];

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];


                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(isVisited[ny][nx]) {
                    continue;
                }

                int dif = Math.abs(map[y][x] - map[ny][nx]);
                if(dif >= l && dif <= r) {
                    flag = true;
                    sum += map[ny][nx];
                    cnt++;
                    isVisited[ny][nx] = true;
                    storage.add(new Node(ny, nx));
                    que.add(new Node(ny, nx));
                }
            }
        }

        if(cnt > 1) {
            int population = sum / cnt;
            while(!storage.isEmpty()) {
                Node cur = storage.poll();
                int y = cur.y;
                int x = cur.x;
                map[y][x] = population;
            }
        }
    }
}
