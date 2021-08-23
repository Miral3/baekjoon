package ex3273;

/*
문제 이름: 두 수의 합
알고리즘: 두 포인터, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int cnt = 0;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            if(arr[left] + arr[right] == x) {
                cnt++;
                left++;
                right--;
            } else if(arr[left] + arr[right] > x) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.close();
    }
}
