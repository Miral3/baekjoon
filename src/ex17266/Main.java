package ex17266;

/*
문제 이름: 어두운 굴다리
알고리즘: 이분 탐색, 매개변수 탐색
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[m + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n;
        int ans = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }

    public static boolean check(int height) {
        int last = 0;
        for (int i = 1; i <= m; i++) {
            if (arr[i] - last <= height) {
                last = arr[i] + height;
            } else {
                return false;
            }
        }
        return last >= n;
    }
}
