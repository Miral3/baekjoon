package ex15565;

/*
문제 이름: 귀여운 라이언
알고리즘: 두 포인터
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

        int[] arr = new int[1000001];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int right = 0;
        int cnt = 0;
        int ans = n + 1;
        for (int left = 1; left <= n; left++) {
            while (right < n && cnt < k) {
                right++;
                if (arr[right] == 1) {
                    cnt++;
                }
            }

            if (cnt == k) {
                ans = Math.min(ans, right - left  + 1);
            }

            if (arr[left] == 1) {
                cnt--;
            }
        }

        if (ans == n + 1) {
            ans = -1;
        }
        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}
