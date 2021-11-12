package ex2693;

/*
문제 이름: N번째 큰 수
알고리즘: 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int[] arr = new int[10];
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(arr);
            bw.write(arr[7] + "\n");
        }

        br.close();
        bw.close();
    }
}
