package ex10025;

/*
문제 이름: 게으른 백곰
알고리즘: 슬라이딩 윈도우
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[1000001];
        int max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int g = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            sum += g;
            arr[x] = g;
            max = Math.max(max, x);
        }

        int left = 0;
        int right = k * 2;
        if (max <= right) {
            System.out.println(sum);
            return;
        }

        sum = 0;
        for (int i = 0; i <= k * 2; i++) {
            sum += arr[i];
        }

        long answer = sum;
        while(true) {
            sum -= arr[left];
            left++;
            right++;
            sum += arr[right];
            answer = Math.max(answer, sum);
            if (right == max) {
                break;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
