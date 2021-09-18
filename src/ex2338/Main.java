package ex2338;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        bw.write(a.add(b) + "\n");
        bw.write(a.subtract(b) + "\n");
        bw.write(a.multiply(b) + "\n");

        br.close();
        bw.close();
    }
}
