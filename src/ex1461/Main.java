package ex1461;

/*
문제 이름: 도서관
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static final int max = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[max];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr, 0, n+1);

        int pivot = 0;
        for (int i = 0; i <= n; i++) {
            if(arr[i] == 0) {
                pivot = i;
                break;
            }
        }

        int result = 0;
        for (int i = 0; i < pivot; i+=m) {
            result += Math.abs(arr[i] * 2);
        }

        for (int i = n; i > pivot; i-= m) {
            result += arr[i] * 2;
        }

        result -= Math.max(Math.abs(arr[0]), arr[n]);

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
