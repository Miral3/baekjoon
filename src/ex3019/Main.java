package ex3019;

/*
문제 이름: 테트리스
알고리즘: 구현, 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int c = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);
        int[] tetris = new int[c];
        input = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            tetris[i] = Integer.parseInt(input[i]);
        }

        int cnt = 0;
        for (int i = 0; i < c; i++) {
            switch (p) {
                case 1: {
                    cnt++; // 0도
                    if (i < c - 3 && tetris[i] == tetris[i + 1] && tetris[i + 1] == tetris[i + 2]
                    && tetris[i + 2] == tetris[i + 3]) {
                        cnt++;
                    }
                    break;
                }
                case 2: {
                    if (i < c - 1 && tetris[i] == tetris[i + 1]) {
                        cnt++;
                    }
                    break;
                }
                case 3: {
                    if (i < c - 2 && tetris[i] == tetris[i + 1] && tetris[i + 1] + 1 == tetris[i + 2]) { // 0도
                        cnt++;
                    }
                    if (i < c - 1 && tetris[i] == tetris[i + 1] + 1) { // 90도
                        cnt++;
                    }
                    break;
                }
                case 4: {
                    if (i < c - 2 && tetris[i] == tetris[i + 1] + 1 && tetris[i + 1] == tetris[i + 2]) { // 0도
                        cnt++;
                    }
                    if (i < c - 1 && tetris[i] + 1 == tetris[i + 1]) { // 90도
                        cnt++;
                    }
                    break;
                }
                case 5: {
                    if (i < c - 2 && tetris[i] == tetris[i + 1] && tetris[i + 1] == tetris[i + 2]) { // 0도
                        cnt++;
                    }
                    if (i < c - 1 && tetris[i] + 1 == tetris[i + 1]) { // 90도
                        cnt++;
                    }
                    if (i < c - 2 && tetris[i] == tetris[i + 1] + 1 && tetris[i + 1] + 1 == tetris[i + 2]) { // 180도
                        cnt++;
                    }
                    if (i < c - 1 && tetris[i] == tetris[i + 1] + 1) { // 270도
                        cnt++;
                    }
                    break;
                }
                case 6: {
                    if (i < c - 2 && tetris[i] == tetris[i + 1] && tetris[i + 1] == tetris[i + 2]) { // 0도
                        cnt++;
                    }
                    if (i < c - 1 && tetris[i] == tetris[i + 1]) { // 90도
                        cnt++;
                    }
                    if (i < c - 2 && tetris[i] + 1 == tetris[i + 1] && tetris[i + 1] == tetris[i + 2]) { // 180도
                        cnt++;
                    }
                    if (i < c - 1 && tetris[i] == tetris[i + 1] + 2) { // 270도
                        cnt++;
                    }
                    break;
                }
                case 7: {
                    if (i < c - 2 && tetris[i] == tetris[i + 1] && tetris[i + 1] == tetris[i + 2]) { // 0도
                        cnt++;
                    }
                    if (i < c - 1 && tetris[i] + 2 == tetris[i + 1]) { // 90도
                        cnt++;
                    }
                    if (i < c - 2 && tetris[i] == tetris[i + 1] && tetris[i + 1] == tetris[i + 2] + 1) { // 180도
                        cnt++;
                    }
                    if (i < c - 1 && tetris[i] == tetris[i + 1]) { // 270도
                        cnt++;
                    }
                    break;
                }
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
