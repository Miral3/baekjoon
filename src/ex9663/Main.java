package ex9663;

/*
문제 이름: N-Queen
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n, cnt;
    static int row[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        row = new int[15];
        cnt = 0;

        dfs(0);

        System.out.println(cnt);

        br.close();
        bw.close();
    }

    public static void dfs(int idx) {
        if(idx == n) {
            cnt++;
            return;
        }

        for(int i = 1; i <= n; i++) {
            row[idx] = i;

            if(possible(idx)) {
                dfs(idx + 1);
            }
        }
    }

    public static boolean possible(int idx) {

        for(int i = 0; i < idx; i++) {
            if(row[idx] == row[i] || idx - i == Math.abs(row[idx] - row[i])) {
                return false;
            }
        }
        return true;
    }
}
