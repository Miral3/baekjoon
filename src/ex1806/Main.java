package ex1806;

/*
문제 이름: 부분합
알고리즘: 두 포인터
자료구조: 베열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        int sum = 0;
        int left = 0;
        int right = 0;
        int[] arr = new int[n];
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);

            if(sum < s) {
                sum += arr[i];
                right = i;
            }
        }

        if(sum < s) {
            System.out.println(0);
            return;
        }

        int min = right - left + 1;
        while (left <= right) {
            int len = right - left + 1;

            if(right == n-1) {
                if(sum < s) {
                    break;
                }
            }
            if(right < (n-1) && sum < s) {
                right++;
                sum += arr[right];
            } else if(sum >= s){
                if(len == 1) {
                    System.out.println(1);
                    return;
                }
                min = Math.min(len, min);

                sum -= arr[left];
                left++;
            }
        }

        System.out.println(min);

        br.close();
        bw.close();
    }
}
