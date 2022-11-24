package ex2578;

/*
문제 이름: 빙고
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 5;
        int[][] info = new int[26][2];
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(input[j]);
                info[num][0] = i;
                info[num][1] = j;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(input[j]);
                int y = info[num][0];
                int x = info[num][1];
                isVisited[y][x] = true;

                if (i == 0 && j < 4) {
                    continue;
                }
                int bingoCnt = 0;

                for (int a = 0; a < n; a++) {
                    boolean bingo = true;
                    for (int b = 0; b < n; b++) {
                        if (!isVisited[b][a]) {
                            bingo = false;
                            break;
                        }
                    }
                    if (bingo) {
                        bingoCnt++;
                    }
                }

                for (int a = 0; a < n; a++) {
                    boolean bingo = true;
                    for (int b = 0; b < n; b++) {
                        if (!isVisited[a][b]) {
                            bingo = false;
                            break;
                        }
                    }
                    if (bingo) {
                        bingoCnt++;
                    }
                }

                for (int a = 0; a < 2; a++) {
                    boolean bingo = true;
                    for (int b = 0; b < n; b++) {
                        if (a == 0) {
                            if (!isVisited[b][b]) {
                                bingo = false;
                                break;
                            }
                        } else {
                            if (!isVisited[b][n - 1 - b]) {
                                bingo = false;
                                break;
                            }
                        }
                    }
                    if (bingo) {
                        bingoCnt++;
                    }
                }
                if (bingoCnt >= 3) {
                    answer = (5 * i) + j + 1;
                    break;
                }

            }
            if (answer != 0) {
                break;
            }
        }


        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
