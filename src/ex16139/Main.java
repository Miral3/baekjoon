package ex16139;

/*
문제 이름: 인간-컴퓨터 상호작용
알고리즘: 누적 합
자료구조: 문자열, 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int[][] prefixSum = new int[input.length + 1][26];

        for (int i = 1; i <= input.length; i++) {
            int num = input[i - 1] - 'a';

            for (int j = 0; j < 26; j++) {
                if (j == num) {
                    prefixSum[i][j] = prefixSum[i - 1][j] + 1;
                } else {
                    prefixSum[i][j] = prefixSum[i - 1][j];
                }
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = input2[0].charAt(0) - 'a';
            int l = Integer.parseInt(input2[1]) + 1;
            int r = Integer.parseInt(input2[2]) + 1;

            int result = prefixSum[r][a] - prefixSum[l - 1][a];
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
