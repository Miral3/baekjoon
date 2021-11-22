package ex15683;

/*
문제 이름: 감시
알고리즘: 구현, 시뮬레이션, 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static String[][] map;
    static int n;
    static int m;
    static int result = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new String[n][m];
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = input[j];
            }
        }

        /*
        1: ->       4개
        2: <-->     2개
        3: 직각      4개
        4: 화살표     4개
        5: 4방향     1개
        */
        int idx = 0;
        int[][] cctv = new int[8][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(Integer.parseInt(map[i][j]) > 0 && Integer.parseInt(map[i][j]) < 6) {
                    cctv[idx][0] = Integer.parseInt(map[i][j]);
                    cctv[idx][1] = i;
                    cctv[idx][2] = j;
                    idx++;
                }
            }
        }

        String[][] temp = new String[n][m];
        int[][] info = new int[idx][4];
        backTracking(temp, 0, idx, cctv, info);

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static void backTracking(String[][] temp, int depth, int idx, int[][] cctv, int[][] info) {
        if (depth == idx) {
            init(temp);

            for(int i = 0; i < idx; i++) {
                selectDirection(info[i][0], info[i][1], info[i][2], info[i][3], temp);
            }

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(temp[i][j].equals("0")) {
                        cnt++;
                    }
                }
            }

            result = Math.min(cnt, result);
            return;
        }

        int type = cctv[depth][0];
        int y = cctv[depth][1];
        int x = cctv[depth][2];
        int size = 4;
        if(type == 2) {
            size = 2;
        } else if(type == 5) {
            size = 1;
        }

        for(int i = 0; i < size; i++) {
            info[depth][0] = type;
            info[depth][1] = y;
            info[depth][2] = x;
            info[depth][3] = i;

            backTracking(temp, depth + 1, idx, cctv, info);
        }
    }

    public static void init(String[][] arr) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = map[i][j];
            }
        }
    }

    public static void selectDirection(int type, int y, int x, int idx, String[][] temp) {
        if(type == 1) {
            fillBlank(y, x, idx, temp);
        } else if(type == 2) {
            if(idx == 0) {
                fillBlank(y, x, 0, temp);
                fillBlank(y, x, 1, temp);
            } else if(idx == 1) {
                fillBlank(y, x, 2, temp);
                fillBlank(y, x, 3, temp);
            }
        } else if(type == 3) {
            if(idx == 0) {
                fillBlank(y, x, 0, temp);
                fillBlank(y, x, 2, temp);
            } else if(idx == 1) {
                fillBlank(y, x, 0, temp);
                fillBlank(y, x, 3, temp);
            } else if(idx == 2) {
                fillBlank(y, x, 1, temp);
                fillBlank(y, x, 2, temp);
            } else if(idx == 3) {
                fillBlank(y, x, 1, temp);
                fillBlank(y, x, 3, temp);
            }
        } else if(type == 4) {
            if(idx == 0) {
                fillBlank(y, x, 0, temp);
                fillBlank(y, x, 2, temp);
                fillBlank(y, x, 3, temp);
            } else if(idx == 1) {
                fillBlank(y, x, 0, temp);
                fillBlank(y, x, 1, temp);
                fillBlank(y, x, 3, temp);
            } else if(idx == 2) {
                fillBlank(y, x, 0, temp);
                fillBlank(y, x, 1, temp);
                fillBlank(y, x, 2, temp);
            } else if(idx == 3) {
                fillBlank(y, x, 1, temp);
                fillBlank(y, x, 2, temp);
                fillBlank(y, x, 3, temp);
            }
        } else if(type == 5) {
            fillBlank(y, x, 0, temp);
            fillBlank(y, x, 1, temp);
            fillBlank(y, x, 2, temp);
            fillBlank(y, x, 3, temp);
        }
    }
    public static void fillBlank(int y, int x, int direction, String[][] arr) {
        if(direction == 0) {
            for(int i = y - 1; i >= 0; i--) {
                if(arr[i][x].equals("0") || arr[i][x].equals("#")) {
                    arr[i][x] = "#";
                } else if(arr[i][x].equals("6")){
                    break;
                } else {
                    continue;
                }
            }
        } else if(direction == 1) {
            for(int i = y + 1; i < n; i++) {
                if(arr[i][x].equals("0") || arr[i][x].equals("#")) {
                    arr[i][x] = "#";
                } else if(arr[i][x].equals("6")){
                    break;
                } else {
                    continue;
                }
            }
        } else if(direction == 2) {
            for(int i = x - 1; i >= 0; i--) {
                if(arr[y][i].equals("0") || arr[y][i].equals("#")) {
                    arr[y][i] = "#";
                } else if(arr[y][i].equals("6")){
                    break;
                } else {
                    continue;
                }
            }
        } else if(direction == 3) {
            for(int i = x + 1; i < m; i++) {
                if(arr[y][i].equals("0") || arr[y][i].equals("#")) {
                    arr[y][i] = "#";
                } else if(arr[y][i].equals("6")){
                    break;
                } else {
                    continue;
                }
            }
        }
    }
}
