package ex6593;

/*
문제 이름: 상범 빌딩
알고리즘: bfs
자료구조: 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int z;
    int y;
    int x;
    int time;

    public Node(int z, int y, int x, int time) {
        this.z = z;
        this.y = y;
        this.x = x;
        this.time = time;
    }
}

public class Main {
    static int l;
    static int r;
    static int c;
    static int result;
    static String[][][] map;
    static int[][][] isVisited;
    static int[][] move = {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("")) {
                continue;
            }
            l = Integer.parseInt(input[0]);
            r = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);

            if(l == 0 && r == 0 && c == 0) {
                break;
            }

            map = new String[l][r][c];
            isVisited = new int[l][r][c];
            result = 0;
            int startL = 0;
            int startY = 0;
            int startX = 0;
            int endL = 0;
            int endY = 0;
            int endX = 0;
            for(int i = 0; i < l; i ++) {
                for(int j = 0; j < r; j++) {
                    input = br.readLine().split("");
                    if(input[0].equals("")) {
                        j -= 1;
                        continue;
                    }
                    for(int k = 0; k < c; k++) {
                        map[i][j][k] = input[k];
                        if(map[i][j][k].equals("S")) {
                            startL = i;
                            startY = j;
                            startX = k;
                        } else if(map[i][j][k].equals("E")) {
                            endL = i;
                            endY = j;
                            endX = k;
                        }
                    }
                }
            }

            bfs(startL, startY, startX);
            result = isVisited[endL][endY][endX] - 1;
            if(result == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + result + " minute(s).\n");
            }
        }

        br.close();
        bw.close();
    }

    public static void bfs(int startL, int startY, int startX) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startL, startY, startX, 0));
        isVisited[startL][startY][startX] = 1;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int z = cur.z;
            int y = cur.y;
            int x = cur.x;
            int time = cur.time;

            for(int i = 0; i < 6; i++) {
                int nl = z + move[i][2];
                int ny = y + move[i][0];
                int nx = x + move[i][1];

                if(nl < 0 || ny < 0 || nx < 0 ||
                    nl >= l || ny >= r || nx >= c) {
                    continue;
                }
                if(map[nl][ny][nx].equals("#")) {
                    continue;
                }
                if(isVisited[nl][ny][nx] != 0) {
                    continue;
                }

                que.add(new Node(nl, ny, nx, time + 1));
                isVisited[nl][ny][nx] = isVisited[z][y][x] + 1;
            }
        }
    }
}
