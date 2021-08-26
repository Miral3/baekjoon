package ex10971;

/*
문제 이름: 외판원 순회 2
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int min = 10000001;
    static int[] arr, output;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][n];
        arr = new int[n];
        output = new int[n];
        isVisited = new boolean[n + 1];

        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(n, 0, cost);

        bw.write(min + "\n");

        br.close();
        bw.close();
    }

    public static void dfs(int n, int depth, int[][] cost) {
        if(depth == n) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                if(cost[output[i]][output[(i + 1) % n]] == 0) {
                    return;
                }
                sum += cost[output[i]][output[(i + 1) % n]];
            }
            if(sum < min) {
                min = sum;
            }
            return;
        }

        for(int i = 0; i< n; i++) {
            if(!isVisited[arr[i]]) {
                isVisited[arr[i]] = true;
                output[depth] = arr[i];
                dfs(n, depth + 1, cost);
                isVisited[arr[i]] = false;
            }
        }
    }
}
