package ex1550;

/*
문제 이름: 16진수
알고리즘: 수학, 구현
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        bw.write(Integer.parseInt(str, 16) + "\n");

        br.close();
        bw.close();
    }
}
