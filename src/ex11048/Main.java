package ex11048;

/*
문제 이름: 이동하기
알고리즘: 다이나믹프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            for(int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                map[i][j] += Math.max(map[i][j-1], Math.max(map[i-1][j], map[i-1][j-1]));
            }
        }

        bw.write(map[n][m] + "\n");
        br.close();
        bw.close();
    }
}
