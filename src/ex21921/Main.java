package ex21921;

/*
문제 이름: 블로그
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
        int x = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int sum = 0;
        int[] answer = new int[2];
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }
        answer[0] = sum;
        answer[1] = 1;

        int left = 0;
        for (int i = x; i < n; i++) {
            sum -= arr[left++];
            sum += arr[i];
            if (sum >= answer[0]) {
                if (sum == answer[0]) {
                    answer[1]++;
                } else {
                    answer[0] = sum;
                    answer[1] = 1;
                }
            }
        }

        if (answer[0] == 0) {
            bw.write("SAD\n");
        } else {
            bw.write(answer[0] + "\n" + answer[1] + "\n");
        }
        br.close();
        bw.close();
    }
}
