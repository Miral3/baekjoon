package ex20365;

/*
문제 이름: 블로그2
알고리즘: 그리디
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int min = 1;
        for (int i = 0; i < n; i++) {
            if (input[i] == 'R') {
                if (i == 0) {
                    min++;
                } else {
                    if (input[i-1] == 'B') {
                        min++;
                    }
                }
            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (input[i] == 'B') {
                if (i == 0) {
                    cnt++;
                } else {
                    if (input[i-1] == 'R') {
                        cnt++;
                    }
                }
            }
        }
        min = Math.min(min, cnt);

        bw.write(min + "\n");
        br.close();
        bw.close();
    }
}
