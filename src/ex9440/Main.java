package ex9440;

/*
문제 이름: 숫자 더하기
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            if (n == 0) {
                break;
            }

            int[] num = new int[10];
            for (int i = 1; i <= n; i++) {
                num[Integer.parseInt(input[i])]++;
            }


            int cnt = 0;
            int a = 0;
            int b = 0;
            while (cnt < n) {
                for (int j = 0; j < 10; j++) {
                    if (num[j] > 0) {
                        if (a == 0 && j == 0) {
                            continue;
                        }
                        a = a * 10 + j;
                        num[j]--;
                        cnt++;
                        break;
                    }
                }
                for (int j = 0; j < 10; j++) {
                    if (num[j] > 0) {
                        if (b == 0 && j == 0) {
                            continue;
                        }
                        b = b * 10 + j;
                        num[j]--;
                        cnt++;
                        break;
                    }
                }
            }
            bw.write(a + b + "\n");
        }

        br.close();
        bw.close();
    }
}
