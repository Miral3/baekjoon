package ex14494;

/*
문제 이름: 다이나믹이 뭐예요?
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    static final int mod = 1000000007;
    static int[] dx = {-1, 0, -1};
    static int[] dy = {0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n + 1][m + 1];

        map[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }

                int min = mod;
                for(int k = 0; k < 3; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if(ny < 1 || nx < 1 || ny > n || nx > m) {
                        continue;
                    }

                    map[i][j] += map[ny][nx];
                    map[i][j] %= mod;
                }

            }
        }

        bw.write(map[n][m] + "\n");

        br.close();
        bw.close();
    }
}
