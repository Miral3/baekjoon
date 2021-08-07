package ex10815;

/*
문제 이름: 숫자 카드
알고리즘: 정렬, 이분 탐색
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sanguen = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i< n; i++) {
            sanguen[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] card = new int[m];
        input = br.readLine().split(" ");
        for(int i = 0; i< m; i++) {
            card[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(sanguen);
        Loop:
        for(int i = 0; i < m; i++) {
            int start = 0;
            int end = n - 1;

            while(start <= end) {
                int mid = (start + end) / 2;

                if(card[i] < sanguen[mid]) {
                    end = mid - 1;
                } else if(card[i] > sanguen[mid]) {
                    start = mid + 1;
                } else {
                    bw.write(1 + " ");
                    continue Loop;
                }
            }

            bw.write(0 + " ");
        }

        br.close();
        bw.close();
    }
}
