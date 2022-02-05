package ex14928;

/*
문제 이름: 큰 수 (BIG)
알고리즘: 수학
자료구조: bigInteger
*/

import java.io.*;

public class Main {
    static final int MOD = 20000303;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        long temp = 0;
        for (int i = 0; i < input.length; i++) {
            temp = (temp * 10 + (input[i] - '0')) % MOD;
        }

        bw.write(temp + "\n");
        br.close();
        bw.close();
    }
}
