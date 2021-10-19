package ex2502;

/*
문제 이름: 떡 먹는 호랑이
알고리즘: 다이나믹 프로그래밍, 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int d = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr = new int[d + 1];
        arr[d] = k;
        int mid = k / 2;
        arr[d - 1] = k - mid;
        arr[d - 2] = mid;
        while(true) {
            boolean isComplete = true;
            for(int i = d - 3; i >= 1; i--) {
                arr[i] = arr[i + 2] - arr[i + 1];
                if(arr[i] > arr[i + 1]) {
                    arr[d - 1]++;
                    arr[d - 2]--;
                    isComplete = false;
                    break;
                }
            }
            if(isComplete) {
                break;
            }
        }
        bw.write(arr[1] + "\n" + arr[2]);
        br.close();
        bw.close();
    }
}
