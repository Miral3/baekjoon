package ex2146;

/*
문제 이름: 다리 만들기
알고리즘: 그래프탐색(bfs)
자료구조: 배열, 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y, x, size;

    public Node(int y, int x, int size) {
        this.y = y;
        this.x = x;
        this.size = size;
    }
}

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<Node> que = new LinkedList<>();
    static Queue<Node> storage = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!isVisited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                }
                findIsland();
            }
        }

        bw.write(min + "\n");

        br.close();
        bw.close();
    }

    public static void bfs(int startY, int startX) {
        que.add(new Node(startY, startX, 0));
        storage.add(new Node(startY, startX, 0));
        isVisited[startY][startX] = true;

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
                if(isVisited[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }

                que.add(new Node(ny, nx, 0));
                storage.add(new Node(ny, nx, 0));
                isVisited[ny][nx] = true;
            }
        }
    }

    public static void findIsland() {
        while(!storage.isEmpty()) {
            Node cur = storage.poll();
            Queue<Node> que = new LinkedList<>();
            que.add(cur);

            boolean[][] copy = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    copy[i][j] = isVisited[i][j];
                }
            }

            while(!que.isEmpty()) {
                Node cur2 = que.poll();

                int y = cur2.y;
                int x = cur2.x;
                int size = cur2.size;

                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    if(copy[ny][nx]) {
                        continue;
                    }
                    if(map[ny][nx] == 0) {
                        que.add(new Node(ny, nx, size + 1));
                        copy[ny][nx] = true;
                    } else {
                        min = Math.min(min, size);
                    }
                }
            }
        }
    }
}
