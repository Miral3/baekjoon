package ex14569;

/*
문제 이름: 시간표 짜기
알고리즘: 비트마스크
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] subject = new long[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            for (int j = 1; j <= k; j++) {
                subject[i] |= ((long)1 << Integer.parseInt(input[j]));
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int cnt = 0;
            int k = Integer.parseInt(input[0]);
            long temp = 0;
            for (int j = 1; j <= k; j++) {
                temp |= ((long)1 << Integer.parseInt(input[j]));
            }
            temp = ~temp;

            for (int j = 0; j < n; j++) {
                if ((temp & subject[j]) == 0) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }

        br.close();
        bw.close();
    }
}
