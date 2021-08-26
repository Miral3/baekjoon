package ex10974;

/*
문제 이름: 모든 순열
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] arr, output;
    static boolean[] isVisited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        output = new int[n];
        isVisited = new boolean[n + 1];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(n, 0);

        br.close();
        bw.close();
    }

    public static void dfs(int n, int  depth) throws IOException {
        if(n == depth) {
            for(int i = 0; i < n; i++) {
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!isVisited[arr[i]]) {
                isVisited[arr[i]] = true;
                output[depth] = arr[i];
                dfs(n, depth + 1);
                isVisited[arr[i]] = false;
            }
        }
    }
}
