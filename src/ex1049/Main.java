package ex1049;

/*
문제 이름: 기타줄
알고리즘: 수학
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        int over = 6 * ((n / 6) + 1);
        int[] dp = new int[102];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int pack = Integer.parseInt(input2[0]);
            int each = Integer.parseInt(input2[1]);

            for(int j = 1; j <= over; j++) {
                int minPack = Math.min(dp[6], pack);
                int minEach = Math.min(dp[1], each);

                int mix = (minPack * (j / 6)) + (minEach * (j % 6));
                int one = minEach * j;

                int min = Math.min(mix, one);
                dp[j] = Math.min(dp[j], min);
            }
        }

        int result = Math.min(dp[n], dp[over]);

        System.out.println(result);

        br.close();
        bw.close();
    }
}
