package ex8370;

/*
문제 이름: Plane
알고리즘: 수학, 사칙연산
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n1 = Integer.parseInt(input[0]);
        int k1 = Integer.parseInt(input[1]);
        int n2 = Integer.parseInt(input[2]);
        int k2 = Integer.parseInt(input[3]);

        bw.write((n1 * k1) + (n2 * k2) + "\n");
        br.close();
        bw.close();
    }
}
