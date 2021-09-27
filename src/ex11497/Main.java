package ex11497;

/*
문제 이름: 통나무 건너뛰기
알고리즘: 정렬, 그리디
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];

            String[] input = br.readLine().split(" ");
            for(int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(input[j - 1]);
            }

            Arrays.sort(arr);

            int max = arr[2] - arr[1];
            max = Math.max(arr[n] - arr[n - 1], max);

            for(int j = 3; j <= n; j+=2) {
                max = Math.max(arr[j] - arr[j - 2], max);
            }
            for(int j = 4; j <= n; j+=2) {
                max = Math.max(arr[j] - arr[j - 2], max);
            }
            bw.write(max + "\n");
        }

        br.close();
        bw.close();
    }
}
