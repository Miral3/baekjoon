package ex16922;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;

public class Main {
    static int n, cnt;
    static int[] arr  = {1, 5, 10, 50};
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        isVisited = new boolean[1001];
        cnt = 0;

        dfs(0, 0, 0);

        bw.write(cnt + "");

        br.close();
        bw.close();
    }

    public static void dfs(int depth, int x, int sum) {
        if(depth == n) {
            if(!isVisited[sum]) {
                isVisited[sum] = true;
                cnt++;
            }
            return;
        }

        for(int i = x; i < 4; i++) {
            dfs(depth + 1, i, sum + arr[i]);
        }
    }
}
