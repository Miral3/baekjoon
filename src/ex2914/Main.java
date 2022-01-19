package ex2914;

/*
문제 이름: 저작권
알고리즘: 수학, 구현, 사칙연산
자료구조: 정수
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int i = Integer.parseInt(input[1]);

        bw.write((a * (i-1)) + 1 + "\n");
        br.close();
        bw.close();
    }
}
