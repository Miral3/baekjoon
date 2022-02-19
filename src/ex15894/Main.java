package ex15894;

/*
문제 이름: 수학은 체육과목 입니다
알고리즘: 수학, 사칙연산
자료구조: long
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Integer.parseInt(br.readLine());
        bw.write(n * 4 + "\n");
        br.close();
        bw.close();
    }
}
