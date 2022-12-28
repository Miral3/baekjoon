package ex1485;

/*
문제 이름: 정사각형
알고리즘: 정렬, 기하학
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Pos[] pos = new Pos[4];
            for (int i = 0; i < 4; i++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                pos[i] = new Pos(x, y);
            }
            long[] dist = new long[6];
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    dist[idx++] = dist(pos[i], pos[j]);
                }
            }

            Arrays.sort(dist);
            if (dist[0] == dist[1] && dist[1] == dist[2] && dist[2] == dist[3] && dist[4] == dist[5]) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        br.close();
        bw.close();
    }

    public static long dist(Pos p1, Pos p2) {
        return 1l * (p1.x - p2.x) * (p1.x - p2.x) + 1l * (p1.y - p2.y) * (p1.y - p2.y);
    }
}
