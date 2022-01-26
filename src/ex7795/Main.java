package ex7795;

/*
문제 이름: 먹을 것인가 먹힐 것인가
알고리즘: 정렬, 이분 탐색
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int sizeA = Integer.parseInt(input[0]);
            int sizeB = Integer.parseInt(input[1]);
            int[] a = new int[sizeA];
            int[] b = new int[sizeB];

            input = br.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }

            input = br.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                b[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(b);
            int result = 0;
            for (int i = 0; i < sizeA; i++) {
                result += binarySearch(b, a[i], sizeB);
            }

            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }

    public static int binarySearch(int[] b, int num, int size) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num <= b[mid]) {
                right = mid;
            } else if (num > b[mid]) {
                left = mid + 1;
            }
        }

        return right;
    }
}
