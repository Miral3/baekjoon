package ex1074;

/*
문제 이름: Z
알고리즘: 분할 정복, 재귀
자료구조: 트리
*/

import java.io.*;

public class Main {
    static int r, c, cnt = 0, result = 0;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        int size = (int)Math.pow(n, 2);
        map = new int[size][size];

        dfs(0, 0, (int)Math.pow(2, n));

        bw.write(result + "\n");

        br.close();
        bw.close();
    }

    public static void dfs(int x, int y, int n) {
        if(r == y && c == x) {
            result = cnt;
            return;
        }
        if(r < y + n && r >= y && c < x + n && c >= x) {
            dfs(x, y, n / 2);
            dfs(x + (n / 2), y, n / 2);
            dfs(x, y + (n / 2), n / 2);
            dfs(x + (n / 2), y + (n / 2), n / 2);
        } else {
            cnt += n * n;
        }
    }
}
