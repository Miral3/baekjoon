package ex13305;

/*
문제 이름: 주유소
알고리즘: 그리디
자료구조: 배열, 빅 인테저
*/

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        BigInteger[] degree = new BigInteger[n - 1];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n-1; i++) {
            degree[i] = new BigInteger(input[i]);
        }

        BigInteger[] price = new BigInteger[n];
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            price[i] = new BigInteger(input[i]);
        }

        BigInteger min = price[0];
        BigInteger result = min.multiply(degree[0]);
        for(int i = 1; i < n-1; i++) {

            if(min.compareTo(price[i]) > 0) {
                min = price[i];
            }

            BigInteger mul = min.multiply(degree[i]);
            result = result.add(mul);
        }

        System.out.println(result);

        br.close();
        bw.close();
    }
}
