package ex16435;

/*
문제 이름: 스네이크 버드
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int[] arr = new int[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] <= l) {
                l++;
            }
        }

        bw.write(l + "\n");
        br.close();
        bw.close();
    }
}
