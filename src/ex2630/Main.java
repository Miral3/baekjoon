package ex2630;

/*
문제 이름: 색종이 만들기
알고리즘: 분할 정복, 재귀
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int[] cnt = new int[2];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0, n);

        bw.write(cnt[0] + "\n" + cnt[1]);

        br.close();
        bw.close();
    }
    public static boolean isSame(int x, int y, int size) {
        int num = map[y][x];

        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(map[i][j] != num) {
                    return false;
                }
            }
        }

        cnt[num]++;
        return true;
    }

    public static void dfs(int x, int y, int size) {
        if(isSame(x, y, size)) {
            return;
        }

        dfs(x, y, size / 2);
        dfs(x, y + (size / 2), size / 2);
        dfs(x + (size / 2), y, size / 2);
        dfs(x + (size / 2), y + (size / 2), size / 2);
    }
}
