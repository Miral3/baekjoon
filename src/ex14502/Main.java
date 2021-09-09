package ex14502;

/*
문제 이름: 연구소
알고리즘: 그래프 탐색, 브루트포스, 백트래킹
자료구조: 배열, 배열 리스트, 큐
*/

import java.io.*;
import java.util.ArrayList;
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
    static int n, m, max = 0;
    static ArrayList<Node> list = new ArrayList<>();
    static String[] blocks;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[] isUsed;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 0) {
                    list.add(new Node(i, j)); // 빈 칸 리스트에 저장
                }
            }
        }
        isUsed = new boolean[list.size()];
        blocks = new String[list.size()];
        // 빈 칸에 3칸 벽 설치하고 바이러스 퍼트린 다음 빈 칸 갯수세어서 최대 크기 출력
        backTracking(0, 0);

        bw.write(max + "");

        br.close();
        bw.close();
    }

    public static void backTracking(int depth, int x) {
        if(depth == 3) {
            isVisited = new boolean[n][m];
            dfs(blocks);
            return;
        }
        for(int i = x; i < list.size(); i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                blocks[depth] = list.get(i).y + "," + list.get(i).x;
                backTracking(depth + 1, x + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void dfs(String[] blocks) {
        int[][] copyMap = new int[n][m];
        for(int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, map[0].length);
        }

        for(int i = 0; i < 3; i++) {
            String[] block = blocks[i].split(",");
            int blockY = Integer.parseInt(block[0]);
            int blockX = Integer.parseInt(block[1]);

            copyMap[blockY][blockX] = 1;
        }

        Queue<Node> que = new LinkedList<>();
        int rootY = 0;
        int rootX = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    rootY = i;
                    rootX = j;
                    que.add(new Node(rootY, rootX));
                    isVisited[rootY][rootX] = true;
                }
            }
        }



        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(isVisited[ny][nx]) {
                    continue;
                }
                if(copyMap[ny][nx] != 0) {
                    continue;
                }

                copyMap[ny][nx] = 2;
                que.add(new Node(ny, nx));
                isVisited[ny][nx] = true;
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(cnt, max);

    }
}
