package ex16943;

/*
문제 이름: 숫자 재배치
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] arr;
    static int[] out;
    static boolean[] isVisited;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        String[] split = Integer.toString(a).split("");
        int n = split.length;
        arr = new int[n];
        out = new int[n];
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        permutation(0, n, b);

        bw.write(max + "\n");
        br.close();
        bw.close();
    }
    public static void permutation(int depth, int n, int b) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum * 10 + out[i];
            }

            if (sum < b) {
                max = Math.max(sum, max);
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                if ((depth == 0 && arr[i] != 0) || depth > 0) {
                    isVisited[i] = true;
                    out[depth] = arr[i];
                    permutation(depth + 1, n, b);
                    isVisited[i] = false;
                }
            }
        }
    }
}
