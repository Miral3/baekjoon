package Ex1418;

/*
문제 이름: K-세준수
알고리즘: 수학, 브루트포스
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            int now = i;
            int max = 0;

            for (int j = 2; j <= Math.sqrt(i);) {
                if (now % j == 0) {
                    now /= j;
                    max = j;
                } else {
                    j++;
                }
            }

            if (now != 1) {
                max = now;
            }
            if (max <= k) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
