package ex14225;

/*
문제 이름: 부분수열의 합
알고리즘: 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] range = new boolean[20 * 100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        setSum(0, 0);

        for (int i = 1; i < range.length; i++) {
            if (!range[i]) {
                bw.write(i +  "\n");
                break;
            }
        }

        br.close();
        bw.close();
    }
    public static void setSum(int depth, int sum) {
        if(depth == n) {
            range[sum] = true;
            return;
        }

        setSum(depth + 1, sum + arr[depth]);
        setSum(depth + 1, sum);
    }
}
