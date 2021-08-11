package ex10819;

/*
문제 이름: 차이를 최대로
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int n;
    static boolean[] isVisited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        isVisited = new boolean[n];
        int[] output = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dfs(output, n, 0);

        System.out.println(max);

        br.close();
        bw.close();
    }

    public static void dfs(int[] output, int n, int depth) {
        if(depth == n) {
            int result = 0;
            for(int i = 0; i < n - 1; i++) {
                result += Math.abs(output[i] - output[i + 1]);
            }

            max = Math.max(result, max);

            return;
        }

        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                output[depth] = arr[i];
                dfs(output, n, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
