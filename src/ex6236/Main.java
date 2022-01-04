package ex6236;

/*
문제 이름: 용돈 관리
알고리즘: 이분 탐색, 매개 변수 탐색
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int left = 1;
        int right = sum;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static boolean isPossible(int k) {
        int cnt = 1;
        int remain = k;

        for (int i = 0; i < n; i++) {
            if (k < arr[i]) {
               return false;
            }

            if(remain - arr[i] < 0) {
                remain = k;
                cnt++;
            }
            remain -= arr[i];
        }

        if (cnt <= m) {
            return true;
        }

        return false;
    }
}
