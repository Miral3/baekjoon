package ex4485;

/*
문제 이름: 녹색 옷 입은 애가 젤다지?
알고리즘: 다익스트라
자료구조: 우선순위 큐, 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int y;
    int x;
    int weight;

    public Node(int y, int x, int weight) {
        this.y = y;
        this.x = x;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static int n;
    static int[][] map;
    static int[][] dp;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            map = new int[n][n];
            dp = new int[n][n];
            isVisited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            dijkstra();
            bw.write("Problem " + idx + ": " + dp[n-1][n-1] + "\n");
            idx++;
        }

        br.close();
        bw.close();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        dp[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int y = cur.y;
            int x = cur.x;

            if (isVisited[y][x]) {
                continue;
            }

            isVisited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >= 0 && nx >= 0 && ny < n && nx < n) {
                    if(dp[ny][nx] > dp[y][x] + map[ny][nx]) {
                        dp[ny][nx] = dp[y][x] + map[ny][nx];
                        pq.add(new Node(ny, nx, dp[ny][nx]));
                    }
                }
            }
        }
    }
}
