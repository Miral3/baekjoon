package ex11652;

/*
문제 이름: 카드
알고리즘: 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);
        int cnt = 1;
        int max = cnt;
        long result = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if(cnt > max) {
                max = cnt;
                result = arr[i];
            }
        }
        System.out.println(result);

        br.close();
        bw.close();
    }
}
