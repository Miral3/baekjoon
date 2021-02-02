package Ex2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int N, cnt, k;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] flooded;
    static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        flooded = new boolean[N][N];
        cnt = 0;
        int max = 0;

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                if(max < Integer.parseInt(input[j])) {
                    max = Integer.parseInt(input[j]);
                }
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(k = 0; k <= max; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !flooded[i][j]) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
            q.add(cnt);
            cnt = 0;
            flooded = new boolean[N][N];
        }
        System.out.println(q.poll());
    }
    public static void DFS(int x, int y) {
        flooded[x][y]= true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!flooded[nx][ny] && map[nx][ny] > k) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
