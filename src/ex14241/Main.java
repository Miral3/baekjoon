package ex14241;

/*
문제 이름: 슬라임 합치기
알고리즘: 정렬, 그리디
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = n - 1; i > 0; i--) {
            int sum = arr[i] + arr[i-1];
            answer += arr[i] * arr[i - 1];
            arr[i-1] = sum;
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
