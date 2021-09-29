package ex3046;

/*
문제 이름: R2
알고리즘: 수학, 구현
자료구조: 
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int r1 = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        bw.write(((s * 2) - r1) + "\n");

        br.close();
        bw.close();
    }
}
