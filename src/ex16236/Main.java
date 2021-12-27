package ex16236;

/*
문제 이름: 아기 상어
알고리즘: BFS, 구현, 시뮬레이션
자료구조: 배열, 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparable<Node>{
    int y;
    int x;
    int cnt;

    public Node(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        if(this.cnt > o.cnt) {
            return 1;
        } else if(this.cnt < o.cnt) {
            return -1;
        } else {
            if(this.y > o.y) {
                return 1;
            } else if(this.y < o.y) {
                return -1;
            } else {
                return this.x - o.x;
            }
        }
    }
}

public class Main {
    static int n;
    static int[][] map;
    static int[][] d;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int startY;
    static int startX;
    static int curSharkSize = 2;
    static int curSharkEatCnt = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];


        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);

                if(map[i][j] == 9) {
                    map[i][j] = 0;
                    startY = i;
                    startX = j;
                }
            }
        }

        while (true) {
            d = new int[n][n];
            int cnt = BFS();

            if(cnt == -1) {
                break;
            } else {
                result += cnt;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
    public static int BFS() {
        Queue<Node> que = new LinkedList<>();
        PriorityQueue<Node> canEat = new PriorityQueue<>();
        que.add(new Node(startY, startX, 0));
        d[startY][startX] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;

            if(map[y][x] != 0 && map[y][x] < curSharkSize) {
                canEat.add(cur);
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(d[ny][nx] != 0) {
                    continue;
                }
                if(map[ny][nx] > curSharkSize) {
                    continue;
                }

                que.add(new Node(ny, nx, cnt + 1));
            }
        }

        if(!canEat.isEmpty()) {
            Node cur = canEat.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;

            curSharkEatCnt++;
            if(curSharkEatCnt == curSharkSize) {
                curSharkSize++;
                curSharkEatCnt = 0;
            }

            map[y][x] = 0;
            startY = y;
            startX = x;

            return cnt;
        }

        return -1;
    }
}
