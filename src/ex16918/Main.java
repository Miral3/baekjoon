package ex16918;

/*
문제 이름: 봄버맨
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
    static int r;
    static int c;
    static int n;
    static String[][] map;
    static String[][] bomb;
    static boolean[][] isVisited;
    static Queue<Node> que = new LinkedList<>();
    static int dy[] = {0, 0, 1, -1};
    static int dx[] = {1, -1, 0, 0};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        n = Integer.parseInt(input[2]);

        map = new String[r][c];
        bomb = new String[r][c];

        for(int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                map[i][j] = input[j];
                bomb[i][j] = ".";
            }
        }

        if(n == 1) { // 1초 후 까지는 아무것도 안하므로 초기값
            printMap();
        } else {
            for (int i = 0; i < r; i++) { // 폭탄 위치 큐, bomb배열에 저장
                for (int j = 0; j < c; j++) {
                    if(map[i][j].equals("O")) {
                        que.add(new Node(i, j));
                        bomb[i][j] = "O";
                    }
                }
            }
            for (int i = 0; i < r; i++) { // 맵을 폭탄으로 채움
                for (int j = 0; j < c; j++) {
                    map[i][j] = "O";
                }
            }

            if (n % 2 == 0) { // 짝수면 폭탄으로 꽉 채워진 맵 출력
                printMap();
            } else {
                bfs(); // 기존에 있던 폭탄을 터침
                if(n % 4 == 3) {
                    printMap();
                } else {
                    for (int i = 0; i < r; i++) { // 초기화
                        for (int j = 0; j < c; j++) {
                            bomb[i][j] = ".";
                        }
                    }

                    for (int i = 0; i < r; i++) { // 폭탄 위치 큐에 저장
                        for (int j = 0; j < c; j++) {
                            if(map[i][j].equals("O")) {
                                que.add(new Node(i, j));
                                bomb[i][j] = "O";
                            }
                        }
                    }

                    for (int i = 0; i < r; i++) { // 맵을 폭탄으로 채움
                        for (int j = 0; j < c; j++) {
                            map[i][j] = "O";
                        }
                    }
                    bfs();
                    printMap();
                }
            }
        }
        br.close();
        bw.close();
    }

    public static void bfs() {
        isVisited = new boolean[r][c];

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            map[y][x] = ".";
            isVisited[y][x] = true;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0|| ny >= r || nx >= c) {
                    continue;
                }
                if(isVisited[ny][nx]) {
                    continue;
                }
                if(bomb[ny][nx].equals("O")) {
                    continue;
                }
                map[ny][nx] = ".";
                isVisited[ny][nx] = true;
            }
        }
    }
    public static void printMap() throws IOException {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.write(map[i][j] + "");
            }
            bw.write("\n");
        }
    }
}
