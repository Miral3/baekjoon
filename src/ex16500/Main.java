package ex16500;

/*
문제 이름: 문자열 판별
알고리즘: 다니아믹 프로그래밍, 문자열
자료구조: 문자열, 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] a = new String[n];
        int[] dp = new int[101];

        for(int i = 0 ; i < n; i++) {
            a[i] = br.readLine();
        }

        dp[s.length()] = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                if(s.indexOf(a[j], i) == i && dp[i + a[j].length()] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        System.out.println(dp[0]);

        br.close();
        bw.close();
    }
}
