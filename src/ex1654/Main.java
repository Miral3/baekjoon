package ex1654;

/*
문제 이름: 랜선 자르기
알고리즘: 매개 변수 탐색
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        long[] arr = new long[k];
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i], max);
        }

        long start = 1;
        long end = max;
        long result = 0;
        while(start <= end) {
            long mid = (start + end) / 2;

            if(check(arr, mid, k, n)) {
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

    public static boolean check(long[] arr, long mid, int k, int n) {
        long cnt = 0;
        for(int i = 0; i < k; i++) {
            cnt += arr[i] / mid;
        }

        if(cnt >= n) {
            return true;
        }

        return false;
    }
}
