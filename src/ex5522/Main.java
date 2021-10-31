package ex5522;

/*
문제 이름: 카드 게임
알고리즘: 수학, 사칙연산
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        for(int i = 0; i < 5; i++) {
            int input = Integer.parseInt(br.readLine());
            result += input;
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
