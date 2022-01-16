package ex14652;

/*
문제 이름: 나는 행복합니다~
알고리즘: 수학
자료구조: 정수
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        int y = k / m;
        int x = k % m;

        bw.write(y + " " + x + "\n");
        br.close();
        bw.close();
    }
}
