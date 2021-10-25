package ex14503;

/*
문제 이름: 로봇 청소기
알고리즘: 구현, bfs
자료구조: 배열, 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y;
    int x;
    int d;

    public Node(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}
public class Main {
    static int r;
    static int c;
    static int result = 0;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new int[r + 1][c + 1];
        isVisited = new boolean[r + 1][c + 1];

        input = br.readLine().split(" ");
        int startY = Integer.parseInt(input[0]);
        int startX = Integer.parseInt(input[1]);
        int startD = Integer.parseInt(input[2]);

        for(int i = 1; i <= r; i++) {
            input = br.readLine().split(" ");
            for(int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        if(map[startY + 1][startX + 1] == 1){
            System.out.println(0);
            return;
        }
        bfs(startY + 1, startX + 1, startD);

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
    public static void bfs(int startY, int startX, int startD) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX, startD));


        while(!que.isEmpty()) {
            Node cur = que.poll();

            boolean isMoved = false;
            int y = cur.y;
            int x = cur.x;
            int d = cur.d;

            if(map[y][x] == 0 && !isVisited[y][x]) {
                isVisited[y][x] = true;
                result++;
            }
            for(int i = 0; i < 4; i++) {
                int nd = d - (i + 1);
                if(nd < 0) {
                    nd += 4;
                }
                int ny = y + dy[nd];
                int nx = x + dx[nd];

                if(ny <= 0 || nx <= 0 || ny > r || nx > c) {
                    continue;
                }
                if(isVisited[ny][nx] || map[ny][nx] == 1) {
                    continue;
                }

                que.add(new Node(ny, nx, nd));
                isMoved = true;
                break;
            }

            if(!isMoved) {
                int nd = (d + 2) % 4;
                int ny = y + dy[nd];
                int nx = x + dx[nd];
                if(ny <= 0 || nx <= 0 || ny > r || nx > c) {
                    continue;
                }
                if(map[ny][nx] == 1) {
                    continue;
                }

                que.add(new Node(ny, nx, d));
            }
        }
    }
}
