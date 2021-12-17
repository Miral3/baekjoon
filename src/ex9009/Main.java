package ex9009;

/*
문제 이름: 피보나치
알고리즘: 그리디
자료구조: 배열
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[45];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 45; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int temp = n;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 44; i >= 1; i--) {
                if(temp >= dp[i]) {
                    list.add(dp[i]);
                    temp -= dp[i];
                }
                if(temp == 0) {
                    break;
                }
            }

            Collections.sort(list);
            for (Integer v : list) {
                bw.write(v + " ");
            }

            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
