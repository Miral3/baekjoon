package ex2212;

/*
문제 이름: 센서
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] sub = new int[n - 1];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        for(int j = 0; j < n - 1; j++) {
            sub[j] = arr[j + 1] - arr[j];
        }

        Arrays.sort(sub);

        if(k > n) {
            System.out.println(0);
            return;
        }

        long result = 0;
        for(int i = 0; i < n - k; i++) {
            result += sub[i];
        }

        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}
