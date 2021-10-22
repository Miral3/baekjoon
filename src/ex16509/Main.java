package ex16509;

/*
문제 이름: 장군
알고리즘: 구현, bfs
자료구조: 배열, 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y;
    int x;
    int cnt;

    public Node(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {
    static int[][] map = new int[10][9];
    static boolean[][] isVisited = new boolean[10][9];
    static int result = 0;
    static int[][][] direction = {{{0, 1}, {1, 2}, {2, 3}, {-1, 2}, {-2, 3}},
    {{0, -1}, {1, -2}, {2, -3}, {-1, -2}, {-2, -3}},
    {{1, 0}, {2, -1}, {3, -2}, {2, 1}, {3, 2}},
    {{-1, 0}, {-2, -1}, {-3, -2}, {-2, 1}, {-3, 2}}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int startY = Integer.parseInt(input[0]);
        int startX = Integer.parseInt(input[1]);
        map[startY][startX] = 1;

        input = br.readLine().split(" ");
        int y = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        map[y][x] = -1;

        bfs(startY, startX);

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static void bfs(int startY, int startX) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX, 0));
        isVisited[startY][startX] = true;

        while(!que.isEmpty()) {
            Node cur = que.poll();

            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;

            if(map[y][x] == -1) {
                result = cnt;
                return;
            }

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 5; j++) {
                    int ny = y + direction[i][j][0];
                    int nx = x + direction[i][j][1];

                    if(!isInside(ny, nx) || isVisited[ny][nx]) {
                        continue;
                    }
                    if(j != 2 && j != 4) {
                        if(map[ny][nx] == -1) {
                            if(j == 0 || j == 3) {
                                break;
                            } else if(j == 1) {
                                j = 3;
                            }
                        }
                    } else {
                        que.add(new Node(ny, nx, cnt + 1));
                        isVisited[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static boolean isInside(int y, int x) {
        if(y < 0 || x < 0 || y >= 10 || x >= 9) {
            return false;
        }
        return true;
    }
}
