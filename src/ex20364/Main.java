package ex20364;

/*
문제 이름: 부동산 다툼
알고리즘: 트리
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        int[] arr = new int[n + 1];
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            int last = 0;
            int temp = x;
            while (temp > 1) {
                if (arr[temp] == 1) {
                    last = temp;
                }
                temp /= 2;
            }
            arr[x] = 1;
            bw.write(last + "\n");
        }

        br.close();
        bw.close();
    }
}
