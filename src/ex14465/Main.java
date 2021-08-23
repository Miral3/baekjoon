package ex14465;

/*
문제 이름: 소가 길을 건너간 이유 5
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
        int b = Integer.parseInt(input[2]);

        int[] arr = new int[n + 1];
        for(int i = 0; i < b; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = 1;
        }

        int cnt = 0;
        for(int i = 1; i <= k; i++) {
            if(arr[i] == 1) {
                cnt++;
            }
        }

        int min = cnt;
        for(int i = k + 1; i <= n; i++) {
            if(arr[i-k] == 1) {
                if(arr[i] == 0) {
                    cnt--;
                }
            } else {
                if(arr[i] == 1) {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }

        bw.write(min + "\n");

        br.close();
        bw.close();
    }
}
