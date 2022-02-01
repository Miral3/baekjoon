package ex14645;

/*
문제 이름: 와이버스 부릉부릉
알고리즘: 구현
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
        }

        bw.write("비와이\n");
        br.close();
        bw.close();
    }
}
