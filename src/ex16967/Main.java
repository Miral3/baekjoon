package ex16967;

/*
문제 이름: 배열 복원하기
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int y = Integer.parseInt(input[3]);
        int[][] arr = new int[h+x][w+y];

        for(int i = 0; i < h+x; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < w+y; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] result = new int[h][w];
        for(int i = 0; i < h+x; i++) {
            for(int j = 0; j < w+y; j++) {
                if((i >= x && j >= y) && (i < h && j < w)) {
                    result[i][j] = arr[i][j] - result[i-x][j-y];
                } else {
                    if(i < h && j < w) {
                        result[i][j] = arr[i][j];
                    }
                }
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
