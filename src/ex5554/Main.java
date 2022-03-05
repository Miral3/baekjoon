package ex5554;

/*
문제 이름: 심부름 가는 길
알고리즘: 수학, 구현, 사칙연산
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        int min = sum / 60;
        int sec = sum - 60 * min;

        bw.write(min + "\n" + sec + "\n");
        br.close();
        bw.close();
    }
}
