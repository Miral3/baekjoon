package ex2559;

/*
문제 이름: 수열
알고리즘: 슬라이딩 윈도우
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        System.out.println(slidingWindow(arr, n, k));

        br.close();
        bw.close();
    }

    public static int slidingWindow(int[] arr, int n, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowEnd;

        for(windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += arr[windowEnd];

            if(windowEnd >= (k-1)) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart += 1;
            }
        }
        return maxSum;
    }
}
