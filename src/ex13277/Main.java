package ex13277;

/*
문제 이름: 큰 수 곱
알고리즘: 수학
자료구조: BigIntger
*/

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        BigInteger A = new BigInteger(input[0]);
        BigInteger B = new BigInteger(input[1]);

        bw.write(A.multiply(B) + "\n");
        br.close();
        bw.close();
    }
}
