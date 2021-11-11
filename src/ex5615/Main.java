package ex5615;

/*
문제 이름: 아파트 임대
알고리즘: 밀러-라빈 소수 판별법, 수학
자료구조: 빅인티저
*/

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i < n; i++) {
            BigInteger a = new BigInteger(br.readLine());
            a = a.multiply(BigInteger.valueOf(2));
            a = a.add(BigInteger.valueOf(1));
            if (a.isProbablePrime(10)) {
                result++;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
