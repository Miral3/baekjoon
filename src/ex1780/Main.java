package ex1780;

/*
문제 이름: 종이의 개수
알고리즘: 분할 정복, 재귀
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] result = new int[3];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new int[2188][2188];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]) + 1;
            }
        }

        divide(0, 0, n);
        for(int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }

        br.close();
        bw.close();
    }

    public static boolean check(int row, int col, int num) {
        int start = map[row][col];
        for(int i = row; i < row + num; i++) {
            for(int j = col; j < col + num; j++) {
                if(start != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void divide(int row, int col, int num) {
        if (check(row, col, num)) {
            result[map[row][col]]++;
        }
        else {
            int size = num / 3;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    divide(row + size * i, col + size * j, size);
                }
            }
        }
    }
}
