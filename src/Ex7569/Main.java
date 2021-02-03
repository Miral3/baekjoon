package Ex7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static boolean[][][] visited;
    static int row, column, high, cnt = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dz = {-1, 1};
    static int[][][] box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        row = Integer.parseInt(input[0]);
        column = Integer.parseInt(input[1]);
        high = Integer.parseInt(input[2]);

        box = new int[high][column][row];
        visited = new boolean[high][column][row];

        for(int k = 0; k < high; k++) {
            for (int i = 0; i < column; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < row; j++) {
                    box[k][i][j] = Integer.parseInt(input[j]);
                }
            }
        }

        BFS();
        System.out.println(cnt);
    }

    public static void BFS() {
        LinkedList<listValue> list = new LinkedList<>();

        for(int k = 0; k < high; k++) {
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                     if(box[k][i][j] == 1) {
                         list.add(new listValue(k, i, j));
                         visited[k][i][j] = true;
                     }
                }
            }
        }

        int size = list.size();

        while(!list.isEmpty()) {
            int z = list.peek().v1;
            int x = list.peek().v2;
            int y = list.peek().v3;
            if(size == 0) {
                size = list.size();
                cnt++;
            }
            list.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < column && ny < row ) {
                    if (box[z][nx][ny] == 0 && !visited[z][nx][ny]) {
                        list.add(new listValue(z, nx, ny));
                        visited[z][nx][ny] = true;
                    }
                }
            }
            for(int i = 0; i < 2; i++) {
                int nz = z + dz[i];
                if (nz >= 0 && nz < high ) {
                    if (box[nz][x][y] == 0 && !visited[nz][x][y]) {
                        list.add(new listValue(nz, x, y));
                        visited[nz][x][y] = true;
                    }
                }
            }
            size--;
        }

        for(int k = 0; k < high; k++) {
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    if(box[k][i][j] == 0 && !visited[k][i][j]) {
                    cnt = -1;
                }
                }
            }
        }
    }
}
class listValue {
    int v1, v2, v3;

    public listValue(int v1, int v2, int v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
}


