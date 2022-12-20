package ex2630;

/*
문제 이름: 색종이 만들기
알고리즘: 분할 정복, 재귀
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[][] map;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        answer = new int[2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(n, 0, 0);

        bw.write(answer[0] + "\n" + answer[1] + "\n");
        br.close();
        bw.close();
    }

    public static boolean checkMap(int n, int y, int x) {
        int num = map[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (map[i][j] != num) {
                    return false;
                }
            }
        }

        answer[num]++;
        return true;
    }

    public static void dfs(int n, int y, int x) {
        if (checkMap(n, y, x)) {
            return;
        }

        dfs(n / 2, y, x);
        dfs(n / 2, y, x + (n / 2));
        dfs(n / 2, y + (n / 2), x);
        dfs(n / 2, y + (n / 2), x + (n / 2));
    }
}
