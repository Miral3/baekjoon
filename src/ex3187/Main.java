package ex3187;

/*
문제 이름: 양치기 꿍
알고리즘: 그래프 탐색
자료구조: 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int r, c;
    static String[][] map;
    static boolean[][] visited;
    static int[] result = new int[2];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new String[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                map[i][j] = input[j];
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if((map[i][j].equals("v") || map[i][j].equals("k")) && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);

        br.close();
        bw.close();
    }

    public static void bfs(int a, int b) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(a, b));
        visited[a][b] = true;

        int wolf = 0;
        int sheep = 0;
        if(map[a][b].equals("v")) {
            wolf++;
        } else {
            sheep++;
        }

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >= 0 && nx >= 0 && ny < r && nx < c) {
                    if(!visited[ny][nx] && !map[ny][nx].equals("#")) {
                        if(map[ny][nx].equals("v")) {
                            wolf++;
                        } else if(map[ny][nx].equals("k")) {
                            sheep++;
                        }
                        que.add(new Node(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        if(sheep > wolf) {
            result[0] += sheep;
        } else {
            result[1] += wolf;
        }
    }
}
