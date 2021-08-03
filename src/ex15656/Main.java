package ex15656;

/*
문제 이름: N과 M (7)
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] arr, output;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n];
        output = new int[m];

        input = br.readLine().split(" ");
        for(int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        func(0);

        br.close();
        bw.close();
    }

    public static void func(int depth) throws IOException {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            output[depth] = arr[i];
            func(depth + 1);
        }
    }
}