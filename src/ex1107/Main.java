package ex1107;

/*
문제 이름: 리모컨
알고리즘: 브루트포스 알고리즘
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static boolean[] isBroken = new boolean[10];
    static int[] out = new int[7];
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        min = Math.abs(100 - n);
        int m = Integer.parseInt(br.readLine());
        if(m != 0) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                isBroken[Integer.parseInt(input[i])] = true;
            }

            if (m == 10) {
                int result = Math.abs(100 - n);
                System.out.println(result);
                return;
            }
        }
        for (int i = 1; i < 7; i++) {
            backTracking(0, i);
        }

        bw.write(min + "\n");
        br.close();
        bw.close();
    }

    public static void backTracking(int depth, int size) {
        if (size == depth) {
            int num = out[0];
            for (int i = 1; i < depth; i++) {
                num= num * 10 + out[i];
            }

            int cnt = depth;
            cnt += Math.abs(n - num);
            min = Math.min(min, cnt);

            if(min == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(size > 1 && depth == 0 && i == 0) {
                continue;
            }
            if(isBroken[i]) {
                continue;
            }
            out[depth] = i;
            backTracking(depth + 1, size);
        }
    }
}
