package ex2503;

/*
문제 이름: 숫자 야구
알고리즘: 구현, 브루트포스, 순열
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int answer = 0;
    static int n;
    static boolean[] isVisited;
    static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        isVisited = new boolean[10];
        score = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] out = new int[3];
        perm(0, out);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
    public static void perm(int depth, int[] out) {
        if (depth == 3) {
            for (int i = 0; i < n; i++) {
                int strike = 0;
                int ball = 0;
                for (int j = 3; j >= 1; j--) {
                    int cur = score[i][0] % (int)Math.pow(10, j) / (int)Math.pow(10, j - 1);
                    if (isVisited[cur]) {
                        if (out[3 - j] == cur) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
                if (strike != score[i][1] || ball != score[i][2]) {
                    return;
                }
            }
            answer++;
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                out[depth] = i;
                perm(depth + 1, out);
                isVisited[i] = false;
            }
        }
    }
}
