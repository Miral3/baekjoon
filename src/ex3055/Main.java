package ex3055;

/*
문제 이름: 탈출
알고리즘: BFS
자료구조: 큐, 배열
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
    static String[][] map;
    static int r;
    static int c;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[][] waterDay;
    static int[][] check;
    static Queue<Node> water = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new String[r][c];
        waterDay = new int[r][c];
        check = new int[r][c];
        for (int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = input[j];

                if(map[i][j].equals("*")) {
                    water.add(new Node(i, j));
                }

                if(map[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }

                if(map[i][j].equals("D")) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        waterBFS();

        BFS();

        if(check[end[0]][end[1]] != 0) {
            bw.write(check[end[0]][end[1]] + "\n");
        } else {
            bw.write("KAKTUS\n");
        }

        br.close();
        bw.close();
    }

    public static void waterBFS() {
        while (!water.isEmpty()) {
            Node cur = water.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < r && nx < c) {
                    if (waterDay[ny][nx] == 0 && map[ny][nx].equals(".")) {
                        waterDay[ny][nx] = waterDay[y][x] + 1;
                        water.add(new Node(ny, nx));
                    }
                }
            }
        }
    }

    public static void BFS() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start[0], start[1]));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < r && nx < c) {
                    if (check[ny][nx] == 0 && (map[ny][nx].equals(".") || map[ny][nx].equals("D"))) {
                        if(waterDay[ny][nx] == 0) {
                            check[ny][nx] = check[y][x] + 1;
                            que.add(new Node(ny, nx));
                        } else {
                            if (waterDay[ny][nx] > check[y][x] + 1) {
                                check[ny][nx] = check[y][x] + 1;
                                que.add(new Node(ny, nx));
                            }
                        }
                    }
                }
            }
        }
    }
}
