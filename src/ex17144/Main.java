package ex17144;

/*
문제 이름: 미세먼지 안녕!
알고리즘: 구현, 시뮬레이션
자료구조: 배열, 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y, x, value;

    public Node(int y, int x, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }
}

public class Main {
    static int r, c, t;
    static int answer = 0;
    static int[][] map;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);

        map = new int[r][c];

        for(int i = 0; i < r; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int k = 0; k < t; k++) {
            bfs();
            for(int i = 0; i < r; i++) {
                if(map[i][0] == -1) {
                    push(i);
                    i++;
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] != -1) {
                    answer += map[i][j];
                }
            }
        }


        bw.write(answer + "\n");

        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 4) {
                    que.add(new Node(i, j, map[i][j]));
                }
            }
        }
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;
            int value = cur.value / 5;
            int cnt = 0;

            for(int i = 0; i < 4; i++) {
                int dy = y + ny[i];
                int dx = x + nx[i];

                if(dy < 0 || dx < 0 || dy >= r || dx >= c) {
                    continue;
                }
                if(map[dy][dx] == -1) {
                    continue;
                }
                map[dy][dx] += value;
                cnt++;
            }
            map[y][x] -= value * cnt;
        }
    }

    public static void push(int y) {
        int[][] clone = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                clone[i][j] = map[i][j];
            }
        }


        for(int i = 2; i < c; i++) {
            clone[y][i] = map[y][i - 1];
        }
        for(int i = y - 1; i >= 0; i--) {
            clone[i][c - 1] = map[i + 1][c - 1];
        }
        for(int i = c - 2; i >= 0; i--) {
            clone[0][i] = map[0][i + 1];
        }
        for(int i = 1; i < y; i++) {
            clone[i][0] = map[i - 1][0];
        }

        clone[y][1] = 0;
        for(int i = 2; i < c; i++) {
            clone[y + 1][i] = map[y + 1][i - 1];
        }
        for(int i = y + 2; i < r; i++) {
            clone[i][c - 1] = map[i - 1][c - 1];
        }
        for(int i = c - 2; i >= 0; i--) {
            clone[r - 1][i] = map[r - 1][i + 1];
        }
        for(int i = r - 2; i > y + 1; i--) {
            clone[i][0] = map[i + 1][0];
        }
        clone[y + 1][1] = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                map[i][j] = clone[i][j];
            }
        }
    }
}
