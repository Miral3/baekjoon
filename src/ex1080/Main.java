package ex1080;

/*
문제 이름: 행렬
알고리즘: 그리디
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
        int[][] arr = new int[n][m];
        int[][] goal = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                goal[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != goal[i][j]) {

                    if (i >= n - 2 || j >= m - 2) {
                        cnt = -1;
                        break;
                    }

                    for (int y = i; y < i + 3; y++) {
                        for (int x = j; x < j + 3; x++) {
                            if (arr[y][x] == 0) {
                                arr[y][x] = 1;
                            } else {
                                arr[y][x] = 0;
                            }
                        }
                    }
                    cnt++;
                }
            }

            if (cnt == -1) {
                break;
            }
        }


        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
