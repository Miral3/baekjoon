package ex16946;

/*
문제 이름: 벽 부수고 이동하기 4
알고리즘: 그래프 탐색(bfs)
자료구조: 배열, 배열 리스트, 해시 셋
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
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

    static int n;
    static int m;
    static int groupCnt;
    static ArrayList<Integer> groupSize = new ArrayList<>();
    static int[][] map;
    static int[][] group;
    static boolean[][] isVisited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        group = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        groupCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !isVisited[i][j]) {
                    bfs(i, j);
                    groupCnt++;
                }
            }
        }

        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    HashSet<Integer> set = new HashSet<>();
                    result[i][j] = 1;

                    for(int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                            continue;
                        }
                        if(map[ny][nx] == 1) {
                            continue;
                        }

                        set.add(group[ny][nx]);
                    }

                    for(Integer idx : set) {
                        result[i][j] += groupSize.get(idx);
                    }
                    result[i][j] %= 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void bfs(int a, int b) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(a, b));
        isVisited[a][b] = true;
        group[a][b] = groupCnt;
        int cnt = 1;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (map[ny][nx] != 0) {
                    continue;
                }
                if (isVisited[ny][nx]) {
                    continue;
                }

                isVisited[ny][nx] = true;
                que.add(new Node(ny, nx));
                group[ny][nx] = groupCnt;
                cnt++;
            }
        }

        groupSize.add(cnt);
    }
}
