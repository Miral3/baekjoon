package Ex10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int mapSize;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] colorCnt = {0, 0, 0};
    static String[] color = {"R", "B", "G"};
    static  String[][] map;
    static String[][] abnormalMap;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        mapSize = Integer.parseInt(br.readLine());
        map = new String[mapSize][mapSize];
        abnormalMap = new String[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];

        for(int i = 0; i < mapSize; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < mapSize; j++) {
                if(input[j].equals("G")) {
                    map[i][j] = input[j];
                    abnormalMap[i][j] = "R";
                }
                else {
                    map[i][j] = input[j];
                    abnormalMap[i][j] = input[j];
                }
            }
        }

        for(int k  = 0; k < 3; k++) {
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if (map[i][j].equals(color[k]) && !visited[i][j]) {
                        DFS(i, j, k);
                        colorCnt[k]++;
                    }
                }
            }
        }
        int normal = colorCnt[0] + colorCnt[1] + colorCnt[2];

        colorCnt = new int[2];
        visited = new boolean[mapSize][mapSize];
        for(int k  = 0; k < 2; k++) {
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if (abnormalMap[i][j].equals(color[k]) && !visited[i][j]) {
                        abnormalDFS(i, j, k);
                        colorCnt[k]++;
                    }
                }
            }
        }
        int abnormal = colorCnt[0] + colorCnt[1];

        System.out.println(normal + " " + abnormal);
    }
    
    public static void DFS(int x, int y, int idx) {
        visited[x][y]= true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < mapSize && ny < mapSize) {
                if(!visited[nx][ny] && map[nx][ny].equals(color[idx])) {
                    DFS(nx, ny, idx);
                }
            }
        }
    }

    public static void abnormalDFS(int x, int y, int idx) {
        visited[x][y]= true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < mapSize && ny < mapSize) {
                if(!visited[nx][ny] && abnormalMap[nx][ny].equals(color[idx])) {
                    abnormalDFS(nx, ny, idx);
                }
            }
        }
    }
}
