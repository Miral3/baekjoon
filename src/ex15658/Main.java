package ex15658;

/*
문제 이름: 연산자 끼워넣기 (2)
알고리즘: 브루트포스, 백트래킹, 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int[] num;
    static int[] signNum = new int[4];
    static int[] out;
    static int min = 1000000001;
    static int max = -1000000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        out = new int[n - 1];
        String[] input = br.readLine().split(" ");
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            signNum[i] = Integer.parseInt(input[i]);
        }

        backTracking(0);

        bw.write(max + "\n" + min + "\n");
        br.close();
        bw.close();
    }

    public static void backTracking(int depth) {
        if (depth == n - 1) {
            int result = num[0];
            for (int i = 0; i < n - 1; i ++) {
                if (out[i] == 0) {
                    result += num[i + 1];
                } else if (out[i] == 1) {
                    result -= num[i + 1];
                } else if (out[i] == 2) {
                    result *= num[i + 1];
                } else if (out[i] == 3) {
                    result /= num[i + 1];
                }
            }
            min = Math.min(min, result);
            max = Math.max(max, result);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if(signNum[i] > 0) {
                signNum[i]--;
                out[depth] = i;
                backTracking(depth + 1);
                signNum[i]++;
            }
        }
    }
}
