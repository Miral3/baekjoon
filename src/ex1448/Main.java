package ex1448;

/*
문제 이름: 삼각형 만들기
알고리즘: 수학, 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int answer = -1;
        for (int i = 0; i < n - 2; i++) {
            int sum = arr[i + 1] + arr[i + 2];
            if (sum > arr[i]) {
                answer = arr[i] + sum;
                break;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
