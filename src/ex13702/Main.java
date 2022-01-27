package ex13702;

/*
문제 이름: 이상한 술집
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
        int k = Integer.parseInt(input[1]);
        long[] arr = new long[n];
        long low = 1;
        long high = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            high = Math.max(high, arr[i]);
        }

        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {

                cnt += arr[i] / mid;
            }

            if (k <= cnt) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(high + "\n");
        br.close();
        bw.close();
    }
}
