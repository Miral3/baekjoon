package ex1992;

/*
문제 이름: 쿼드트리
알고리즘: 분할 정복, 재귀
자료구조: 트리
*/

import java.io.*;

public class Main {
    static int[][] map;
    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0,  n);

        bw.write(result + "\n");

        br.close();
        bw.close();
    }
    public static boolean isSame(int x, int y, int n) {
        int num = map[y][x];

        for(int i = y; i < y + n; i++) {
            for(int j = x; j < x + n; j++) {
                if(map[i][j] != num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void dfs(int x, int y, int n) {
        int num = map[y][x];

        if(isSame(x, y, n)) {
            result += num;
            return;
        } else {
            result += "(";
        }

        dfs(x, y, n / 2);
        dfs(x + (n / 2), y, n / 2);
        dfs(x, y + (n / 2), n / 2);
        dfs(x + (n / 2), y + (n / 2), n / 2);
        result += ")";
    }
}
