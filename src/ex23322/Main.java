package ex23322;

/*
문제 이름: 초콜릿 뺏어 먹기
알고리즘: 그리디 알고리즘, 애드 혹
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        int i = k;
        int[] answer = new int[2];
        while (i < n) {
            if (arr[i] == arr[i - k]) {
                i++;
                continue;
            }

            answer[0] += arr[i] - arr[i - k];
            answer[1]++;
            arr[i] = arr[i - k];
            if (i != n - 1) {
                i++;
            }
            Arrays.sort(arr);
        }

        bw.write(answer[0] + " " + answer[1] + "\n");
        br.close();
        bw.close();
    }
}
