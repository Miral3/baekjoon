package ex1629;

/*
문제 이름: 곱셈
알고리즘: 분할 정복
자료구조: 트리
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);

        System.out.println(pow(A, B, C));

        br.close();
        bw.close();
    }
    static long pow(long A, long B, long C) {

        if(B == 1) {
            return A % C;
        }

        long x = pow(A, B / 2, C) % C;

        if(B % 2 == 1) {
            return (x * x % C) * A % C;
        }
        return x * x % C;
    }
}