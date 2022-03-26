package ex9659;

/*
문제 이름: 돌 게임 5
알고리즘: 게임 이론
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        if (n % 2 == 0) {
            bw.write("CY\n");
        } else {
            bw.write("SK\n");
        }

        br.close();
        bw.close();
    }
}
