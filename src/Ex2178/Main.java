package Ex2178;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int length, width;
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new char[length][width];
        isVisited = new boolean[length][width];

        for (int i = 0; i < length; i++) {
            String dwell = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = (dwell.charAt(j));
            }
        }

        count = new int[length][width];
        bfs();
        System.out.print(count[length-1][width-1]);
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        isVisited[0][0] = true;
        count[0][0] = 1;

        while (!q.isEmpty()) {
            Point xy=q.poll();
            int x= (int) xy.getX();
            int y= (int) xy.getY();
//            int x = q.poll().x;
//            int y = q.poll().y;
//            q.poll();
            if (!(y + 1 >= width) && map[x][y + 1] == '1' && !isVisited[x][y + 1]) {
                isVisited[x][y + 1] = true;
                q.add(new Point(x, y + 1));
                count[x][y+1] = count[x][y] + 1;
            }
            if (!(x + 1 >= length) && map[x + 1][y] == '1' && !isVisited[x + 1][y]) {
                isVisited[x + 1][y] = true;
                q.add(new Point(x + 1, y));
                count[x+1][y] = count[x][y] + 1;
            }
            if (!(y - 1 < 0) && map[x][y - 1] == '1' && !isVisited[x][y - 1]) {
                isVisited[x][y - 1] = true;
                q.add(new Point(x, y - 1));
                count[x][y-1] = count[x][y] + 1;
            }
            if (!(x - 1 < 0) && map[x - 1][y] == '1' && !isVisited[x - 1][y]) {
                isVisited[x-1][y] = true;
                q.add(new Point(x - 1, y));
                count[x-1][y] = count[x][y] + 1;
            }
        }
    }
}
