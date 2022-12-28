package ex1789;

/*
문제 이름: 수들의 합
알고리즘: 수학, 그리디
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long s = Long.parseLong(br.readLine());
        long i = 1;
        long sum = 1;
        while (true) {
            if (s >= sum + i + 1) {
                i++;
                sum += i;
            } else {
                break;
            }
        }
        bw.write(i + "\n");
        br.close();
        bw.close();
    }
}
