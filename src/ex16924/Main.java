package ex16924;

/*
문제 이름: 십자가 찾기
알고리즘: 구현, 브루트포스, 시뮬레이션
자료구조: 배열
*/

import java.io.*;
import java.util.ArrayList;

class Node {
    int y;
    int x;
    int size;

    public Node(int y, int x, int size) {
        this.y = y;
        this.x = x;
        this.size = size;
    }
}

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        char[][] map = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            char[] input2 = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input2[j - 1];
            }
        }

        int size = Math.min(n, m);
        ArrayList<Node> result = new ArrayList<>();
        boolean[][] isVisited = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == '*') {
                    int cnt = 0;
                    ArrayList<Node> temp = new ArrayList<>();
                    temp.add(new Node(i, j, 0));
                    for (int k = 1; k <= (size / 2); k++) {
                        boolean isCross = true;

                        for (int l = 0; l < 4; l++) {
                            int y = i + (k * dy[l]);
                            int x = j + (k * dx[l]);

                            if (y <= 0 || x <= 0 || y > n || x > m) {
                                isCross = false;
                                break;
                            }

                            if (map[y][x] != '*') {
                                isCross = false;
                                break;
                            }

                            temp.add(new Node(y, x, 0));
                        }

                        if (!isCross) {
                            break;
                        }

                        cnt++;
                    }

                    if (cnt > 0) {
                        for (int k = cnt; k >= 1; k--) {
                            result.add(new Node(i, j, k));
                        }
                        for (int k = 0; k < temp.size(); k++) {
                            Node cur = temp.get(k);
                            isVisited[cur.y][cur.x] = true;
                        }
                    }
                }
            }
        }

        boolean canMake = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == '*' && !isVisited[i][j]) {
                    canMake = false;
                    break;
                }
            }
            if (!canMake) {
                break;
            }
        }

        if (!canMake) {
            bw.write("-1\n");
        } else {
            bw.write(result.size() + "\n");
            for (int i = 0; i < result.size(); i++) {
                Node cur = result.get(i);
                bw.write(cur.y + " " + cur.x + " " + cur.size + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
