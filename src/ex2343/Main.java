package ex2343;

/*
문제 이름: 기타 레슨
알고리즘: 이분 탐색, 매개 변수 탐색
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        long left = 0;
        long max = 0;

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            max += arr[i];
            left = Math.max(left, arr[i]);
        }

        long right = max;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }

            if (sum != 0) {
                cnt++;
            }

            if (cnt <= m) {
                right = mid - 1;
            } else if (cnt > m) {
                left = mid + 1;
            }
        }

        bw.write(left + "\n");
        br.close();
        bw.close();
    }
}
