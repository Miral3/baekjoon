package ex2792;

/*
문제 이름: 보석 상자
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

        int[] arr = new int[m];
        int high = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }

        int low = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;

            for (int i = 0; i < m; i++) {
                int div = arr[i] / mid;
                int remain = arr[i] % mid;

                if (div == 0) {
                    cnt += 1;
                } else {
                    if (remain == 0) {
                        cnt += div;
                    } else {
                        cnt += div + 1;
                    }
                }
            }

            if (cnt > n) {
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
