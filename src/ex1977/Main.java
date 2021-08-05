package ex1977;

/*
문제 이름: 완전제곱수
알고리즘: 구현
자료구조: 정수
*/

import java.io.*;

public class Main {
    static final int MAX = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] pow = new int[MAX];
        for(int i = 1; i < MAX; i++) {
            pow[i] = (int)Math.pow(i, 2);
        }

        int start = 0;
        int end = 0;
        for(int i = 1; i < MAX; i++) {
            if(m <= pow[i] && m > pow[i - 1]) {
                start = i;
            }

            if(n == pow[i]) {
                end = i;
            } else if(n < pow[i] && n > pow[i-1]) {
                end = i - 1;
            }

            if(start != 0 && end != 0) {
                break;
            }
        }

        if(start > end) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += pow[i];
        }

        System.out.println(sum);
        System.out.println((int)Math.pow(start, 2));

        br.close();
        bw.close();
    }
}
