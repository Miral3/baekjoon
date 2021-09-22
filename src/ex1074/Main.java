package ex1074;

/*
문제 이름: Z
알고리즘: 분할 정복, 재귀
자료구조: 트리
*/

import java.io.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int size = (int)Math.pow(n, 2);

        dfs(n, r, c);
        bw.write(result + "\n");

        br.close();
        bw.close();
    }

    public static void dfs(int n, int r, int c) {
        if(n == 0) {
            return;
        }
        if(r >= 0 && r <= Math.pow(2, n - 1) - 1) {
            if(c >= Math.pow(2, n - 1) && c <= Math.pow(2, n)) { // 2사분면
                result += Math.pow(4, n - 1);
                dfs(n - 1, r, c - (int)Math.pow(2, n-1));
            } else {  // 1사분면
                dfs(n - 1, r, c);
            }
        } else if(r >= Math.pow(2, n - 1) && r <= Math.pow(2, n)) {
            if(c >= Math.pow(2, n - 1) && c <= Math.pow(2, n)) { // 4사분면
                result += Math.pow(4, n - 1) * 3;
                dfs(n - 1, r - (int)Math.pow(2, n-1), c  - (int)Math.pow(2, n-1));
            } else { // 3사분면
                result += Math.pow(4, n - 1) * 2;
                dfs(n - 1, r - (int) Math.pow(2, n - 1), c);
            }
        }
    }
}
