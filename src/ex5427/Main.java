package ex5427;

/*
문제 이름: 불
알고리즘: 구현, BFS
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
    static int w;
    static int h;
    static char[][] map;
    static Queue<Node> fire;
    static int[][] fireCnt;
    static int[][] check;
    static int[] start = new int[2];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            fireCnt = new int[h][w];
            check = new int[h][w];
            map = new char[h][w];
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                char[] info = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = info[j];

                    if(map[i][j] == '@') {
                        start[0] = i;
                        start[1] = j;
                    }

                    if(map[i][j] == '*') {
                        fire.add(new Node(i, j));
                    }
                }
            }

            fireBFS();

            int result = BFS();
            if (result == -1) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(result + "\n");
            }
        }

        br.close();
        bw.close();
    }

    public static void fireBFS() {
        while (!fire.isEmpty()) {
            Node cur = fire.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < h && nx < w) {
                    if (fireCnt[ny][nx] == 0 && (map[ny][nx] == '@' || map[ny][nx] == '.')) {
                        fire.add(new Node(ny, nx));
                        fireCnt[ny][nx] = fireCnt[y][x] + 1;
                    }
                }
            }
        }
    }

    public static int BFS() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start[0], start[1]));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < h && nx < w) {
                    if (check[ny][nx] == 0 && map[ny][nx] == '.') {
                        if (fireCnt[ny][nx] == 0) {
                            que.add(new Node(ny, nx));
                            check[ny][nx] = check[y][x] + 1;
                        } else {
                            if (fireCnt[ny][nx] > check[y][x] + 1) {
                                que.add(new Node(ny, nx));
                                check[ny][nx] = check[y][x] + 1;
                            }
                        }
                    }
                } else {
                    return check[y][x] + 1;
                }
            }
        }

        return -1;
    }
}
