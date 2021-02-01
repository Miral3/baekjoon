package Ex2583;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static int m, n, cnt, testCase;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] map;
    static boolean[][] visited;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        testCase = Integer.parseInt(input[2]);
        map = new boolean[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < testCase; i++) {
            input = br.readLine().split(" ");
            int leftX = Integer.parseInt(input[0]);
            int leftY = Integer.parseInt(input[1]);
            int rightX = Integer.parseInt(input[2]);
            int rightY = Integer.parseInt(input[3]);
            fill(leftX, leftY, rightX, rightY);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!map[i][j] && !visited[i][j]) {
                    cnt = 1;
                    DFS(i, j);
                    q.add(cnt);
                }
            }
        }
        int size = q.size();
        System.out.println(size);
        for(int i = 0; i < size; i++) {
            System.out.print(q.poll() + " ");
        }
    }

    public static void fill(int lX, int lY, int rX, int rY) {
        lY = m - lY;
        rY = m - rY;
        for(int i = rY; i < lY; i++) {
            for(int j = lX; j < rX; j++) {
                if(!map[i][j]) {
                    map[i][j] = true;
                }
            }
        }
    }
    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if(!map[nx][ny] && !visited[nx][ny]) {
                    cnt++;
                    DFS(nx, ny);
                }
            }
        }
    }
}
