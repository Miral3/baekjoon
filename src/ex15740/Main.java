package ex15740;

/*
문제 이름: A+B - 9
알고리즘: 수학
자료구조: BigInteger
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
        System.out.println(a.add(b));

        br.close();
        bw.close();
    }
}
