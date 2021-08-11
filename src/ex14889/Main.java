package ex14889;

/*
문제 이름: 스타트와 링크
알고리즘: 브루트포스, 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static boolean[] isVisited;
    static int[][] ability;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        isVisited = new boolean[n];
        ability = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(input[j]);
            }
        }

        backTracking(0, 0);

        bw.write(min + "\n");

        br.close();
        bw.close();
    }

    public static void backTracking(int idx, int depth) {
        if(depth == n / 2) {
            int start = 0;
            int link = 0;

            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(isVisited[i] && isVisited[j]) {
                        start += ability[i][j];
                        start += ability[j][i];
                    }
                    else if(!isVisited[i] && !isVisited[j]) {
                        link += ability[i][j];
                        link += ability[j][i];
                    }
                }
            }

            if(min == 0) {
                System.out.println(min);
                System.exit(0);
            }

            min = Math.min(min, Math.abs(start - link));
            return;
        }

        for(int i = idx; i < n; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                backTracking(i + 1, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
