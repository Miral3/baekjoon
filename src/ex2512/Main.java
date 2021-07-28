package ex2512;

/*
문제 이름: 예산
알고리즘: 이분 탐색
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n, m;
    static long mid;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[n];
        m = Integer.parseInt(br.readLine());

        long max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            max = Math.max(max, arr[i]);
        }

        long start = 1;
        long end = max;
        long result = 0;
        while(start <= end) {
            mid = (start + end) / 2;

            if(check()) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

        br.close();
        bw.close();
    }

    public static boolean check() {
        int sum = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] > mid) {
                sum += mid;
            } else {
                sum += arr[i];
            }
        }

        if(sum <= m) {
            return true;
        } else
            return false;
    }
}
