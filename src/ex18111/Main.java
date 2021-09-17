package ex18111;

/*
문제 이름: 마인크래프트
알고리즘: 구현, 브루트포스
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
        int b = Integer.parseInt(input[2]);

        int[][] map = new int[n][m];
        int min = 257;
        int max = 0;
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int result = Integer.MAX_VALUE;
        int height = 0;
        for(int k = max; k >= min; k--) {
            int blocks = b;
            int costTime = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int size = map[i][j] - k;

                    if(size == 0) {
                        continue;
                    }

                    if(size > 0) {
                        blocks += size;
                        costTime += size * 2;
                    }
                    else {
                        size = Math.abs(size);
                        blocks -= size;
                        costTime += size;
                    }
                }
            }

            if(blocks >= 0) {
                if(costTime < result) {
                    result = costTime;
                    height = k;
                }
            }
        }

        bw.write(result + " " + height + "\n");
        br.close();
        bw.close();
    }
}
