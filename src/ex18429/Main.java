package ex18429;

/*
문제 이름: 근손실
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int k;
    static int[] healthKit;
    static boolean[] isVisited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        healthKit = new int[n];
        isVisited = new boolean[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            healthKit[i] = Integer.parseInt(input[i]);
        }

        backTracking(0, 500);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static void backTracking(int depth, int weight) {
        if (depth == n) {
            answer++;
        }

        for (int i = 0; i < n; i++) {
            int nextWeight = weight - k + healthKit[i];

            if (isVisited[i]) {
                continue;
            }
            if (nextWeight < 500) {
                continue;
            }

            isVisited[i] = true;
            backTracking(depth + 1, nextWeight);
            isVisited[i] = false;
        }
    }
}
