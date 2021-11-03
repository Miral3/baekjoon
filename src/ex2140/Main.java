package ex2140;

/*
문제 이름: 지뢰찾기
알고리즘: 구현, 그리디
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = input[j];
            }
        }

        // 동서남북좌상우상좌하우하
        int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
        int result = 0;
        for(int i = 1; i < n-1; i++) {
            for(int j = 1; j < n-1; j++) {
                boolean flag = true; // 상하좌우 및 대각산이 모두 폭탄일 때
                boolean isBomb = true;

                // 먼저 상하좌우 및 대각선중에 테두리 일 때 0인지 확인한다.
                for(int k = 0; k < 8; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    // 상하좌우 및 대각선중에 테두리 일 때
                    if(ny == 0 || ny == n-1 || nx == 0 || nx == n-1) {
                        flag = false;
                        if(map[ny][nx].equals("0")) {
                            isBomb = false;
                            break;
                        }
                    }
                }

                if(flag) {
                    result++;
                    continue;
                }

                if(isBomb) {
                    for(int k = 0; k < 8; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        // 상하좌우 및 대각선중에 테두리 일 때
                        if(ny == 0 || ny == n-1 || nx == 0 || nx == n-1) {
                            int curNum = Integer.parseInt(map[ny][nx]);
                            map[ny][nx] = Integer.toString(curNum-1);
                        }
                    }
                    result++;
                }
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
