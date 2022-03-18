package ex2790;

/*
문제 이름: F7
알고리즘: 정렬, 애드 혹
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        int num = n;
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i] + num, max);
            num--;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (max <= arr[i] + n) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
