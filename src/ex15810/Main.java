package ex15810;

/*
문제 이름: 풍선 공장
알고리즘: 이분 탐색, 매개 변수 탐색
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);
        long[] arr = new long[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(arr);

        long low = 1;
        long high = arr[0] * m;
        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += mid / arr[i];
            }

            if (cnt < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(low + "\n");
        br.close();
        bw.close();
    }
}
