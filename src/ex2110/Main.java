package ex2110;

/*
문제 이름: 공유기 설치
알고리즘: 이분 탐색
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n;
    static int c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n-1] - arr[0];
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static boolean isPossible(int dist) {
        int cnt = 1;
        int prev = arr[0];

        for (int i = 1; i < n; i++) {
            if(arr[i] - prev >= dist) {
                cnt++;
                prev = arr[i];
            }
        }

        if (cnt >= c) {
            return true;
        }

        return false;
    }
}
