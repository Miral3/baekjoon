package ex1756;

/*
문제 이름: 피자 굽기
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int d = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] oven = new int[d];
        int[] pizza = new int[n];
        input = br.readLine().split(" ");
        for(int i = 0; i < d; i++) {
            oven[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            pizza[i] = Integer.parseInt(input[i]);
        }

        for(int i = 1; i < d; i++) {
            if(oven[i] > oven[i-1]) {
                oven[i] = oven[i-1];
            }
        }

        int idx = 0;
        int result = 0;
        for(int i = d-1; i >= 0; i--) {
            if(idx > n - 1) {
                break;
            }
            if(pizza[idx] <= oven[i]) {
                result = i+1;
                idx++;
            }
        }

        if(idx == n) {
            bw.write(result + "\n");
        } else {
            bw.write(0 + "\n");
        }

        br.close();
        bw.close();
    }
}
