package ex1644;

/*
문제 이름: 소수의 연속합
알고리즘: 두 포인터
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] arr = new int[290000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int idx = 0;
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                arr[idx++] = i;
            }
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;
        while(right <= idx) {

            if(sum < n) {
                sum += arr[right++];
            } else {
                if(sum == n) {
                    cnt++;
                }
                sum -= arr[left++];
            }
        }

        System.out.println(cnt);

        br.close();
        bw.close();
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
