package ex10757;

/*
문제 이름: 큰 수 A+B
알고리즘: 수학, 구현, 사칙연산
자료구조: 빅인티저
*/

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);

        bw.write(a.add(b) + "\n");


        br.close();
        bw.close();
    }
}
