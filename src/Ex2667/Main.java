package Ex2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int cnt = 0, N;
    static boolean[][] visited;
    static String[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input;
        map = new String[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j].equals("1") && !visited[i][j]) {
                    cnt = 1;
                    DFS(i, j);
                    q.add(cnt);
                }
            }
        }
        int size = q.size();
        System.out.println(size);
        for(int i = 0; i < size; i++) {
            System.out.println(q.poll());
        }
    }
    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i =0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(map[nx][ny].equals("1") && !visited[nx][ny]) {
                    cnt++;
                    DFS(nx,ny);
                }
            }
        }
    }
}
