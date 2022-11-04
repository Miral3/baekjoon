package ex9237;

/*
문제 이름: 이장님 초대
알고리즘: 그리디, 정렬
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
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] + i + 2);
        }

        bw.write(max + "\n");
        br.close();
        bw.close();
    }
}
