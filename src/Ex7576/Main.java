package Ex7576;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] visited;
    static int row, column, cnt = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        column = Integer.parseInt(input[1]);

        box = new int[column][row];
        visited = new boolean[column][row];
        for(int i = 0; i < column; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < row; j++) {
                box[i][j] = Integer.parseInt(input[j]);
            }
        }

        BFS();
        System.out.println(cnt);
    }

    public static void BFS() {
        Queue<Point> q = new LinkedList<>();
        
        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                if(box[i][j] == 1) {
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int size = q.size();

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            if(size == 0) {
                size = q.size();
                cnt++;
            }
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < column && ny < row) {
                    if(box[nx][ny] == 0 && !visited[nx][ny]) {
                        q.add(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            size--;
        }

        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                if(box[i][j] == 0 && !visited[i][j]) {
                    cnt = -1;
                }
            }
        }
    }
}
