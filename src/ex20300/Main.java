package ex20300;

/*
문제 이름: 서강근육맨
알고리즘: 그리디 알고리즘, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long max = 0;
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(arr);

        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                long sum = arr[i] + arr[n - 1 - i];
                max = Math.max(max, sum);
            }
        } else {
            max = arr[n-1];
            for (int i = 0; i < n / 2; i++) {
                long sum = arr[i] + arr[n - 2 - i];
                max = Math.max(max, sum);
            }
        }

        bw.write(max + "\n");
        br.close();
        bw.close();
    }
}
