package Ex4963;

import java.io.*;

public class Main {
    /* 좌, 우, 상, 하, 좌상, 우상, 좌하, 우하*/
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int w, h, cnt;
    static String[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            cnt = 0;
            map = new String[h][w];
            visited = new boolean[h][w];

            if(w == 0 && h == 0) {
                break;
            }

            for(int i = 0; i < h; i++) {
                input = br.readLine().split(" ");
                for(int j = 0; j < w; j++) {
                    map[i][j] = input[j];
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j].equals("1")) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if(map[nx][ny].equals("1") && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
