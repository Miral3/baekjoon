package ex18222;

/*
문제 이름: 투에-모스 문자열
알고리즘: 분할 정복, 재귀
자료구조: long
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long k = Long.parseLong(br.readLine());
        bw.write(dfs(k) + "\n");
        br.close();
        bw.close();
    }

    public static int dfs(long k) {
        if (k == 1) {
            return 0;
        }
        int minPower = (int)(Math.log10(k) / Math.log10(2));
        long min = (long)Math.pow(2, minPower);
        if (min == k) {
            min = (long)Math.pow(2, minPower - 1);
        }
        return 1 - dfs(k - min);
    }
}
