package Ex2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int count;
    static char[][] map;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size;
        size = Integer.parseInt(br.readLine());
        map = new char[size][size];
        isVisited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String dwell = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = (dwell.charAt(j));
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((!isVisited[i][j]) && map[i][j] == '1') {
                    isVisited[i][j] = true;
                    count = 1;
                    dfs(i, j, size);
                    q.add(count);
                }
            }
        }
        int qSize = q.size();
        System.out.println(qSize);
        for (int i = 0; i < qSize; i++) {
            System.out.println(q.poll());
        }
    }

    public static void dfs(int x, int y, int size) {
        if (!(x - 1 < 0) && map[x - 1][y] == '1' && (!isVisited[x - 1][y])) {
            count++;
            isVisited[x - 1][y] = true;
            dfs(x - 1, y, size);
        }
        if (!(x + 1 >= size) && map[x + 1][y] == '1' && (!isVisited[x + 1][y])) {
            count++;
            isVisited[x + 1][y] = true;
            dfs(x + 1, y, size);
        }
        if (!(y - 1 < 0) && map[x][y - 1] == '1' && (!isVisited[x][y - 1])) {
            count++;
            isVisited[x][y - 1] = true;
            dfs(x, y - 1, size);
        }
        if (!(y + 1 >= size) && map[x][y + 1] == '1' && (!isVisited[x][y + 1])) {
            count++;
            isVisited[x][y + 1] = true;
            dfs(x, y + 1, size);
        }

    }
}
