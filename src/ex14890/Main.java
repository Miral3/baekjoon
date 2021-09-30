package ex14890;

/*
문제 이름: 경사로
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int l;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++ ) {
            boolean isCrossed = true;
            int currentHeight = map[i][0];
            boolean[] hasRamp = new boolean[n];

            for(int j = 1; j < n; j++) {
                if(currentHeight == map[i][j]) {
                    continue;
                } else if(Math.abs(currentHeight - map[i][j]) > 1) {
                    isCrossed = false;
                } else if(currentHeight > map[i][j]) {
                    for(int k = j; k < j + l; k++) {
                        if(k >= n || map[i][k] != currentHeight - 1 || hasRamp[k]) {
                            isCrossed = false;
                            break;
                        }
                        hasRamp[k] = true;
                    }

                    currentHeight -= 1;
                } else if(currentHeight < map[i][j]) {
                    for(int k = j - 1; k >= j - l; k--) {
                        if(k < 0 || map[i][k] != map[i][j] - 1 || hasRamp[k]) {
                            isCrossed = false;
                            break;
                        }
                        hasRamp[k] = true;
                    }

                    currentHeight += 1;
                }

                if(!isCrossed) {
                    break;
                }
            }

            if(isCrossed) {
                cnt++;
            }
        }

        for(int i = 0; i < n; i++ ) {
            boolean isCrossed = true;
            int currentHeight = map[0][i];
            boolean[] hasRamp = new boolean[n];

            for(int j = 1; j < n; j++) {
                if(currentHeight == map[j][i]) {
                    continue;
                } else if(Math.abs(currentHeight - map[j][i]) > 1) {
                    isCrossed = false;
                } else if(currentHeight > map[j][i]) {
                    for(int k = j; k < j + l; k++) {
                        if(k >= n || map[k][i] != currentHeight - 1 || hasRamp[k]) {
                            isCrossed = false;
                            break;
                        }
                        hasRamp[k] = true;
                    }

                    currentHeight -= 1;
                } else if(currentHeight < map[j][i]) {
                    for(int k = j - 1; k >= j - l; k--) {
                        if(k < 0 || map[k][i] != map[j][i] - 1 || hasRamp[k]) {
                            isCrossed = false;
                            break;
                        }
                        hasRamp[k] = true;
                    }

                    currentHeight += 1;
                }

                if(!isCrossed) {
                    break;
                }
            }

            if(isCrossed) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
